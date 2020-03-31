(ns main
  (:require
   [pinkgorilla.bundler :refer [generate-config-bundle]]
   ; Sample Config Files
   [config.gorilla :refer [gorilla]]
   [config.small :refer [small]]
   [config.mariacloud :refer [mariacloud]])
  (:gen-class))

(def bundle-config
  {:small small
   :gorilla  gorilla
   :mariacloud  mariacloud})

(defn get-config [name]
  (let [k (keyword name)]
    (k bundle-config)))

(defn generate-config [name]
  (let [settings (get-config name)]
    (generate-config-bundle name settings)))


(defn -main [& args]
  (let [symbol (first args)]
    (println "Generating Bundle for: " symbol)
    (generate-config symbol)
))


(comment

  (generate-config "small")

  (generate-config "mariacloud")

  ; comment end
  )