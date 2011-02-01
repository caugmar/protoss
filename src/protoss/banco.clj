(ns protoss.banco
  (:use clojure.contrib.sql))

(defn ler []
  (let [db-host "localhost"
        db-name "cobranca"
        db {:classname "com.mysql.jdbc.Driver"
            :subprotocol "mysql"
            :subname (str "//" db-host "/" db-name)
            :user "caugm"
            :password "caugm"}]
    (with-connection db (with-query-results rs ["select * from documentos_de_cobranca"] (seq rs)))))

