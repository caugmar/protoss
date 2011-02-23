(ns protoss.extensos
  (:use [clojure.string :only [split replace]]))

(def digitos {0 "zero" 1 "um" 2 "dois" 3 "três" 4 "quatro" 5 "cinco" 6 "seis" 7 "sete" 8 "oito" 9 "nove"})
(def excessoes {10 "dez" 11 "onze" 12 "doze" 13 "treze" 14 "quatorze" 15 "quinze" 
                16 "dezesseis" 17 "dezessete" 18 "dezoito" 19 "dezenove"})
(def dezenas {20 "vinte" 30 "trinta" 40 "quarenta" 50 "cinqüenta" 60 "sessenta" 70 "setenta" 80 "oitenta" 90 "noventa"})
(def centenas {100 "cento" 200 "duzentos" 300 "trezentos" 400 "quatrocentos" 500 "quinhentos" 
               600 "seiscentos" 700 "setecentos" 800 "oitocentos" 900 "novecentos"})

(defn dezena [numero]
  (cond 
    (< numero 10) (digitos numero)
    (and (>= numero 10) (< numero 20)) (excessoes numero)
    (>= numero 20) (if (= (mod numero 10) 0) 
                     (dezenas numero)
                     (str (dezenas (- numero (mod numero 10))) " e " (digitos (mod numero 10))))))

(defn centena [numero]
  (if (< numero 100) (dezena numero)
    (if (= (mod numero 100) 0)
      (if (= numero 100) "cem" (centenas numero))
      (str (centenas (- numero (mod numero 100))) " e " (dezena (mod numero 100))))))

(defn milhar [numero]
  (if (< numero 1000) (centena numero)
    (if (= (mod numero 1000) 0)
      (str (centena (/ numero 1000)) " mil")
      (str (centena (/ (- numero (mod numero 1000)) 1000)) " mil, " (centena (mod numero 1000))))))

(defn separar [numero] 
  (let [[inteiros decimais] (split (str numero) #"\.")
        decimal-preenchido (replace (format "%-2s" decimais) " " "0")]
    (map #(Integer. %) [inteiros decimal-preenchido])))

(defn em-reais [numero]
  (let [[inteiros centavos] (separar numero)]
    (cond
      (and (= inteiros 0) (= centavos 0)) ""
      (and (= inteiros 0) (= centavos 1)) "um centavo"
      (= inteiros 0) (str (dezena centavos) " centavos")
      (and (not= inteiros 0) (= centavos 0)) (str (milhar inteiros) " reais")
      (and (not= inteiros 0) (= centavos 1)) (str (milhar inteiros) " reais e um centavo")
      :else (str (milhar inteiros) " reais e " (dezena centavos) " centavos"))))
