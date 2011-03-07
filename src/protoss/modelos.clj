(ns protoss.modelos
  (:import [org.antlr.stringtemplate StringTemplateGroup])
  (:use protoss.planilha protoss.banco clojure.string))

(def templates (StringTemplateGroup. "templates" "./templates/"))
(def recibos-aluguel (.getInstanceOf templates "recibos-aluguel"))
(def recibos-escritorio (.getInstanceOf templates "recibos-escritorio"))

(defn procusto [lista]
  (take 4 (concat lista ["" "" "" ""])))

(defn ajustar [texto tamanho]
  (subs (format (str "%-" tamanho "s") texto) 0 tamanho))

(defn emitir-documentos [emissao]
  (conectar-ao-banco
    (doseq [modelo modelos]
      (doseq [documento (obter-documentos modelo emissao)]
        (let [itens (procusto (obter-itens (:id documento)))
              template (.getInstanceOf templates (.toLowerCase modelo))]
          (doto template
            (.setAttribute "nome" (ajustar (:nome documento) 52)))
          (println (.toString template)))))))

