(ns protoss.modelos
  (:import [org.antlr.stringtemplate StringTemplateGroup])
  (:use [protoss planilha banco]))

(def templates (StringTemplateGroup. "templates" "./templates/"))
(def recibos-aluguel (.getInstanceOf templates "recibos-aluguel"))
(def recibos-escritorio (.getInstanceOf templates "recibos-escritorio"))

(defn procusto [lista]
  (take 4 (concat lista ["" "" "" ""])))

(defn ajustar [texto tamanho]
  (subs (format (str "%-" tamanho "s") texto) 0 tamanho))

(defn preencher [template documento & campos]
  (doseq [campo campos]
    (let [campo-template (campo 0)
          campo-documento (campo 1)
          largura-campo (campo 2)]
      (.setAttribute template campo-template (ajustar (campo-documento documento) largura-campo)))))

(defn emitir-documentos [emissao]
  (conectar-ao-banco
    (doseq [modelo modelos]
      (doseq [documento (obter-documentos modelo emissao)]
        (let [itens (procusto (obter-itens (:id documento)))
              template (.getInstanceOf templates (.toLowerCase modelo))]
          (preencher template documento
                     ["nome"    :nome 52]
                     ["nffs"    :numero_da_nota 6]
                     ["bairro"  :bairro 18]
                     ["cep"     :cep 9]
                     ["u"       :estado 3]
                     ["cidade"  :cidade 10]
                     ["emissao" :data_de_emissao 10]
                     ["vcto"    :data_de_vencimento 10])
          (println (.toString template)))))))

