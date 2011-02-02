(ns protoss.core
  (:import [org.apache.commons.cli Options GnuParser HelpFormatter]))

(defmacro se-opcao [cmdline opt & body]
  `(when (.hasOption ~cmdline ~opt)
     ~@body))

(defmacro se-opcao-com-arg [cmdline opt arg & body]
  `(se-opcao ~cmdline ~opt
       (let [~arg (.getOptionValue ~cmdline ~opt)]
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

(defn -main [& args]
  (let [opcoes (configurar-opcoes)
        parser (GnuParser.)
        cmdline (.parse parser opcoes (into-array (conj args "")))]
    (doto cmdline
      (se-opcao "c"
                (println "Carregando..."))
      (se-opcao "g"
                (println "Gerando..."))
      (se-opcao-com-arg "e" data-de-emissao
                        (println (str "Emitindo " data-de-emissao "...")))
      (se-opcao-com-arg "r" data-de-emissao
                        (println (str "Gerando relatórios de " data-de-emissao "...")))
      (se-opcao-com-arg "p" data-de-emissao
                        (println (str "Atualizando planilhas com os dados de " data-de-emissao "...")))
      (se-opcao-com-arg "x" data-de-emissao
                        (println (str "Excluindo dados de " data-de-emissao "...")))
      (se-opcao "h"
                (.printHelp (HelpFormatter.) "protoss" opcoes)))
    nil))

