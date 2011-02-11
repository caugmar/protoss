(ns protoss.modelos
  (:import [org.antlr.stringtemplate StringTemplate]
           [org.antlr.stringtemplate.language DefaultTemplateLexer]))

(defn exibir []
  (let [tpl (StringTemplate. "Hello, $nome$!" DefaultTemplateLexer)]
    (.setAttribute tpl "nome" "Guto Marcicano")
    (str tpl)))

