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

(defn proximo-numero [modelo]
  (let [query "select max(numero_da_nota)+1 from documentos_de_cobranca where modelo like ?"
        resultados (sql-query query modelo)
        numero (first (vals (first resultados)))]
    numero))

