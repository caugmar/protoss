(ns protoss.planilha
  (:import [org.jopendocument.dom.spreadsheet SpreadSheet]
           [org.jopendocument.dom OOUtils]
           [javax.swing.table TableModel DefaultTableModel]
           [java.io File]))

(defn criar []
  (let [data (to-array-2d [["janeiro", 1],
                           ["fevereiro", 2],
                           ["março", 3]])
        colunas (to-array ["Mês", "Temperatura"])
        modelo (DefaultTableModel. data colunas)     
        arq (File. "temperatura.ods")]
    (.saveAs (SpreadSheet/createEmpty modelo) arq)
    (OOUtils/open arq)))

(defn ler-linha [planilha linha campos] 
  (apply merge 
    (map (fn [i] {(keyword (.toLowerCase (.getValueAt planilha 0 i))) (.getValueAt planilha linha i)})
         (range campos))))

(defn ler []
  (let [arquivo (File. "dados.ods")
        planilha (SpreadSheet/createFromFile arquivo)
        empresas (.getTableModel (.getSheet planilha 0) 0 0)
        lancamentos (.getTableModel (.getSheet planilha 1) 0 0)
        empresas-lidas (remove (fn [registro] (= (:cliente registro) ""))
                               (map (fn [i] (ler-linha empresas i 15))
                                    (range (inc (.getRowCount empresas)))))
        lancamentos-lidos (remove (fn [registro] (= (:cliente registro) ""))
                                  (map (fn [i] (ler-linha lancamentos i 5))
                                       (range (inc (.getRowCount lancamentos)))))]
    [empresas-lidas lancamentos-lidos]))

