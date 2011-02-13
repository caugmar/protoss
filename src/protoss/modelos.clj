(ns protoss.modelos
  (:import [org.antlr.stringtemplate StringTemplateGroup]))

(def modelos (StringTemplateGroup. "templates" "./templates/"))
(def aviso (.getInstanceOf modelos "aviso"))
(def minister (.getInstanceOf modelos "minister"))
(def lbm (.getInstanceOf modelos "lbm"))
(def recibos-aluguel (.getInstanceOf modelos "recibos-aluguel"))
(def recibos-escritorio (.getInstanceOf modelos "recibos-escritorio"))

