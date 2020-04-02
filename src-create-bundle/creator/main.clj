(ns creator.main
  (:require
   [pinkgorilla.bundler :refer [generate-config-bundle]]
   ; Sample Config Files
   [creator.config.gorilla :refer [gorilla]]
   [creator.config.small :refer [small]]
   [creator.config.mariacloud :refer [mariacloud]])
  (:gen-class))

(def bundle-config
  {:small small
   :gorilla  gorilla
   :mariacloud  mariacloud})

(defn get-config [name]
  (let [k (keyword name)]
    (k bundle-config)))

(defn generate-config [config-dir bundle-dir name]
  (let [settings (get-config name)]
    (generate-config-bundle config-dir bundle-dir name settings)))

;; we create public/public
;; reason: if we only create a /bundles resource, then shadow in notebook will
;; try to compile the compiled bundle again!!

(def config-dir "out/bundles") ;; relative to project dir
(def bundle-dir "../../public/public/bundles/") ;; relative to bundle-project-dir, example: out/bundles/gorilla
(def bundle-web-dir "./out/public/public/bundles")

(defn -main [& args]
  (let [symbol (first args)]
    (println "Generating Bundle for: " symbol)
    (generate-config config-dir bundle-dir symbol)
))


(comment

  (generate-config config-dir bundle-dir "small")

  (generate-config config-dir bundle-dir "mariacloud")

  ; comment end
  )