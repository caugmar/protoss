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
