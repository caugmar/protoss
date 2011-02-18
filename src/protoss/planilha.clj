(ns protoss.planilha
  (:import [org.jopendocument.dom.spreadsheet SpreadSheet]
           [java.io File])
  (:use protoss.banco))

(defn ler-linha [planilha linha campos] 
  (apply merge 
         (map (fn [i] {(keyword (.toLowerCase (.getValueAt planilha 0 i))) 
                       (.getValueAt planilha linha i)})
              (range campos))))

(defn ler-configuracao [planilha linha] 
  {(keyword (.toLowerCase (.getValueAt planilha linha 0))) 
   (.getValueAt planilha linha 1)})

(defn obter [planilha nome]
  (.getTableModel (.getSheet planilha nome) 0 0))

(defn extrair-tabela [table-model field-count remove-function sort-function] 
  (vec (sort-by sort-function
                (remove remove-function
                        (map #(ler-linha table-model % field-count)
                             (range 1 (.getRowCount table-model)))))))

(defn extrair-configuracoes [table-model] 
  (apply merge (remove #(= (first (keys %)) "")
                       (map #(ler-configuracao table-model %)
                            (range 1 (.getRowCount table-model))))))

(let [planilha (SpreadSheet/createFromFile (File. "dados.ods"))]
  (def empresas (extrair-tabela (obter planilha "Empresas") 15 #(= (:cliente %) "") :nome))
  (def lancamentos (extrair-tabela (obter planilha "Lançamentos") 5 
                                   #(or (= (:qtd %) 0) (= (:cliente %) "")) 
                                   (fn [c] [(:modelo c) (:cliente c) (:descricao c)])))
  (def configuracoes (extrair-configuracoes (obter planilha "Configurações"))))

(def modelos (sort (set (map :modelo lancamentos))))

(defn empresas-por-modelo [modelo]
  (sort (set (map :cliente 
                  (filter #(= (:modelo %) modelo)
                          lancamentos)))))

(defn empresa-por-codigo [codigo] 
  (first (filter #(= (:cliente %) codigo) 
                 empresas)))

(defn lancamentos-por-modelo-e-codigo [modelo codigo]
  (sort-by #(str (:descricao %))
           (filter #(and (= (:modelo %) modelo)
                         (= (:cliente %) codigo))
                   lancamentos)))

(defn gerar-documentos []
  (doseq [modelo modelos 
          codigo (empresas-por-modelo modelo)]
    (let [empresa (empresa-por-codigo codigo)
          emissao (:emissao configuracoes)
          vencimento (:vencimento configuracoes)]
      (println (str modelo " - " codigo " - " (:nome empresa) " - " emissao " - " vencimento))
      (doseq [lancamento (lancamentos-por-modelo-e-codigo modelo codigo)]
        (println (str " -> " lancamento))))))

