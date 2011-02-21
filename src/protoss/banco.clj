(ns protoss.banco
  (:use clojure.contrib.sql))

(def db {:classname "com.mysql.jdbc.Driver"
         :subprotocol "mysql"
         :subname "//localhost/cobranca2"
         :user "caugm"
         :password "caugm"})

(defmacro conectar-ao-banco [& body]
  `(with-connection db ~@body))

(defn sql-query [& query] 
  (with-query-results resultados (vec query) 
                      (vec resultados)))

(defn proximo-numero [modelo]
  (let [query "select max(numero_da_nota)+1 from documentos_de_cobranca where modelo like ?"
        resultados (sql-query query modelo)
        numero (first (vals (first resultados)))]
    numero))

(defn id-atual [modelo]
  (let [query "select max(id) from documentos_de_cobranca where modelo like ?"
        resultados (sql-query query modelo)
        id (first (vals (first resultados)))]
    id))

(defn novo-documento [modelo emissao vencimento empresa lancamentos]
  (let [numero (proximo-numero modelo)
        campos [:nome :logradouro :numero :complemento :bairro :cidade :estado :cep 
                :cnpj :inscricao_estadual :inscricao_municipal :telefone :email]]
    (insert-values :documentos_de_cobranca
                   (vec (concat [:numero_da_nota] campos [:data_de_emissao :data_de_vencimento :modelo]))
                   (vec (concat [numero] (map empresa campos) [emissao vencimento modelo])))
    (doseq [lancamento lancamentos]
      (insert-values :itens_de_cobranca
                     [:documento :quantidade :descricao :valor]
                     (vec (concat [(id-atual modelo)] (map lancamento [:quantidade :descricao :valor])))))))

