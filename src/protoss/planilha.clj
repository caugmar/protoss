(ns protoss.planilha
  (:import [org.jopendocument.dom.spreadsheet SpreadSheet]
           [org.jopendocument.dom OOUtils]
           [javax.swing.table TableModel DefaultTableModel]
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

(let [arquivo (File. "dados.ods")
      planilha (SpreadSheet/createFromFile arquivo)
      empresas-lidas (.getTableModel (.getSheet planilha "Empresas") 0 0)
      lancamentos-lidos (.getTableModel (.getSheet planilha "Lançamentos") 0 0)
      configuracoes-lidas (.getTableModel (.getSheet planilha "Configurações") 0 0)]
  (def empresas (vec (sort-by :nome 
                              (remove #(= (:cliente %) "")
                                      (map #(ler-linha empresas-lidas % 15)
                                           (range 1 (.getRowCount empresas-lidas)))))))
  (def lancamentos (vec (sort-by (fn [c] [(:modelo c) (:cliente c) (:descricao c)])
                                 (remove #(or (= (:qtd %) 0) (= (:cliente %) ""))
                                         (map #(ler-linha lancamentos-lidos % 5)
                                              (range 1 (.getRowCount lancamentos-lidos)))))))
  (def configuracoes (apply merge (remove #(= (first (keys %)) "")
                                          (map #(ler-configuracao configuracoes-lidas %)
                                               (range 1 (.getRowCount configuracoes-lidas)))))))

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
          numero (proximo-numero modelo)
          emissao (:emissao configuracoes)
          vencimento (:vencimento configuracoes)]
      (println (str modelo " - " codigo " - " (:nome empresa) " - " emissao " - " vencimento " - " numero))
      (doseq [lancamento (lancamentos-por-modelo-e-codigo modelo codigo)]
        (println (str " -> " lancamento))))))

