(ns protoss.banco
  (:use clojure.contrib.sql))

(def db {:classname "com.mysql.jdbc.Driver"
         :subprotocol "mysql"
         :subname "//localhost/cobranca2"
         :user "caugm"
         :password "caugm"})

(defn sql-query [ & query] 
  (with-connection db 
                   (with-query-results resultados 
                                       (vec query) 
                                       (vec resultados))))

(defn ler [] 
  (println 
    (sql-query "select * from documentos_de_cobranca where id = ?" "133")))

