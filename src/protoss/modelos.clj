(ns protoss.modelos
  (:import [org.antlr.stringtemplate StringTemplateGroup]))

(def modelos (StringTemplateGroup. "templates" "."))
(def aviso (.getInstanceOf modelos "aviso"))
(def minister (.getInstanceOf modelos "minister"))
(def lbm (.getInstanceOf modelos "lbm"))

