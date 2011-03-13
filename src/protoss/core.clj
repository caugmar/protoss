(ns protoss.core
  (:import [org.apache.commons.cli Options GnuParser HelpFormatter])
  (:use protoss.modelos)
  (:gen-class))

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

(defn mostrar-ajuda [opcoes] 
  (.printHelp (HelpFormatter.) "protoss" opcoes))

(defn dispatcher [args opcoes]
  (let [parser (GnuParser.)
        cmdline (.parse parser opcoes (into-array (conj args "")))]
    (doto cmdline
      (se-opcao "c" (println "Carregando..."))
      (se-opcao "g" (println "Gerando..."))
      (se-opcao-com-arg "e" emissao (emitir-documentos emissao))
      (se-opcao-com-arg "r" emissao (println (str "Gerando relatórios de " emissao "...")))
      (se-opcao-com-arg "p" emissao (println (str "Atualizando planilhas com os dados de " emissao "...")))
      (se-opcao-com-arg "x" emissao (println (str "Excluindo dados de " emissao "...")))
      (se-opcao "h" (mostrar-ajuda opcoes))))
  nil)

(defn -main [& args]
  (let [opcoes (configurar-opcoes)]
    (try (dispatcher args opcoes)
      (catch Exception e (mostrar-ajuda opcoes)))))

