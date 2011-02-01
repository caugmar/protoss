(ns protoss.core
  (:import [org.apache.commons.cli Options GnuParser HelpFormatter]))

(defmacro if-option [cmd opt & body]
  `(when (.hasOption ~cmd ~opt)
       ~@body))

(defmacro if-option-with-arg [cmd opt arg & body]
  `(when (.hasOption ~cmd ~opt)
     (let [~arg (.getOptionValue ~cmd ~opt)]
       ~@body)))

(defn configurar-opcoes []
  (doto (Options.)
    (.addOption "h" "help" false "informações de uso")
    (.addOption "c" "carregar" false "carrega as planilhas no banco de dados")
    (.addOption "g" "gerar" false "gera os documentos de cobrança")
    (.addOption "e" "emissao" true "emite os documentos de cobrança referentes à data de emissão")
    (.addOption "d" "dos" false "codifica para impressão em CP850 (MS-DOS)")
    (.addOption "r" "relatorios" true "gera os relatórios de cobrança referentes à data de emissão")
    (.addOption "p" "planilhas" true "atualiza as planilhas dos clientes com os documentos referentes à data de emissão")
    (.addOption "x" "excluir" true "remove do banco de dados os documentos referentes à data de emissão")))

(defn -main []
  (let [opcoes (configurar-opcoes)
        cmd (.parse (GnuParser.) opcoes (into-array ["-c" "--gerar" "-e 01/02/2011" "-h"]))]
    (if-option cmd "c"
      (println "Carregando..."))
    (if-option cmd "g"
      (println "Gerando..."))
    (if-option-with-arg cmd "e" data-de-emissao
        (println (str "Emitindo" data-de-emissao "...")))
    (if-option-with-arg cmd "r" data-de-emissao
        (println (str "Gerando relatórios de" data-de-emissao "...")))
    (if-option-with-arg cmd "p" data-de-emissao
        (println (str "Atualizando planilhas com os dados de" data-de-emissao "...")))
    (if-option-with-arg cmd "x" data-de-emissao
        (println (str "Excluindo dados de" data-de-emissao "...")))
    (if-option cmd "h"
      (.printHelp (HelpFormatter.) "protoss" opcoes))))

