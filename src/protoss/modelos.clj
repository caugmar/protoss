(ns protoss.modelos
  (:import [org.antlr.stringtemplate StringTemplateGroup]
           [java.text DecimalFormat])
  (:use [protoss planilha banco extensos]))

(def templates (StringTemplateGroup. "templates" "./templates/"))
(def recibos-aluguel (.getInstanceOf templates "recibos-aluguel"))
(def recibos-escritorio (.getInstanceOf templates "recibos-escritorio"))

(defn procusto [lista]
  (vec (take 4 (concat lista (repeat 4 {:quantidade "" :descricao "" :valor 0})))))

(defn ajustar [texto tamanho]
  (subs (format (str "%-" tamanho "s") texto) 0 tamanho))

(let [formato (DecimalFormat. "###,##0.00")]
  (defn dinheiro [valor]
    (if (= valor 0) ""
      (format "%11s" (try (.format formato valor)
                       (catch java.lang.IllegalArgumentException e valor))))))

(defn quebrar [texto local]
  (if (>= (inc local) (.length texto))
    [texto ""]
    (let [posicao (loop [i local]
                    (if (= (subs texto i (inc i)) " ")
                      i
                      (recur (dec i))))]
      [(subs texto 0 posicao) (subs texto (inc posicao))])))

(defn preencher [template documento & campos]
  (doseq [campo campos]
    (let [campo-template (campo 0)
          campo-documento (campo 1)
          largura-campo (campo 2)]
      (if (keyword? campo-documento)
        (.setAttribute template campo-template (ajustar (campo-documento documento) largura-campo))
        (.setAttribute template campo-template (ajustar campo-documento largura-campo))))))


(defn emitir-documentos [emissao]
  (conectar-ao-banco
    (doseq [modelo modelos]
      (doseq [documento (obter-documentos modelo emissao)]
        (let [itens (procusto (obter-itens (:id documento)))
              template (.getInstanceOf templates (.toLowerCase modelo))
              endereco-aviso (str (:logradouro documento) ", " (:numero documento) 
                                  (if (not= (:complemento documento) "-") (str " - " (:complemento documento))))
              [endereco1 endereco2] (quebrar endereco-aviso 48)
              endereco-notas (str endereco-aviso " - " (:bairro documento) " - " (:cidade documento)
                                  " - " (:estado documento) " - CEP " (:cep documento))
              [endereco3 endereco4] (quebrar endereco-notas 48)
              total (reduce + (map :valor itens))]
          (preencher template documento
                     ["nome" :nome 52]
                     ["nffs" (format "%06d" (:numero_da_nota documento)) 6]
                     ["endereco1" endereco1 48]
                     ["endereco2" endereco2 48]
                     ["endereco3" endereco1 48]
                     ["endereco4" endereco2 58]
                     ["bairro" :bairro 18]
                     ["cep" :cep 9]
                     ["u" :estado 3]
                     ["cidade" :cidade 10]
                     ["cnpj" :cnpj 18]
                     ["ie" :inscricao_estadual 15]
                     ["im" :inscricao_municipal 5]
                     ["q1" (:quantidade (itens 0)) 4]
                     ["d1" (:descricao (itens 0)) 36]
                     ["v1" (dinheiro (:valor (itens 0))) 11]
                     ["q2" (:quantidade (itens 1)) 4]
                     ["d2" (:descricao (itens 1)) 36]
                     ["v2" (dinheiro (:valor (itens 1))) 11]
                     ["q3" (:quantidade (itens 2)) 4]
                     ["d3" (:descricao (itens 2)) 36]
                     ["v3" (dinheiro (:valor (itens 2))) 11]
                     ["q4" (:quantidade (itens 3)) 4]
                     ["d4" (:descricao (itens 3)) 36]
                     ["v4" (dinheiro (:valor (itens 3))) 11]
                     ["emissao" :data_de_emissao 10]
                     ["vcto" :data_de_vencimento 10]
                     ["total" (dinheiro total) 11]
                     ["extenso" (em-reais total) 69])
          (println (str (.toString template) "\n\n")))))))

