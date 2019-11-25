(ns pinkgorilla.bundler
  (:require
   [clojure.java.io]
   [clojure.pprint]
   [cheshire.core :refer :all]
   [pinkgorilla.bundle-config :refer [bundle-config]]))

(defn package-json [npm-deps]
  (let [filename "package.json"
        my-pretty-printer (create-pretty-printer
                           (assoc default-pretty-print-options
                                  :indent-arrays? true))
        config  {:dependencies (assoc npm-deps "shadow-cljs" "^2.0.41") } ]
    (spit filename (generate-string config {:pretty my-pretty-printer}))))


(defn shadow-bundle [bundle-name settings]
  (let [filename "shadow-cljs.edn"
        config {:dependencies (:maven settings)
                :source-paths ["src"]
                :builds {bundle-name {:target :bootstrap
                                      :output-dir (str "out/" (name bundle-name))
                                      :exclude    #{'cljs.js}
                                      :entries (:ns settings)}}}]
     (spit filename (with-out-str (clojure.pprint/pprint config)))
    
    ))


;(defn shadow-cljs [config]
;  {:builds (reduce shadow-bundle {} config)})



(defn generate-config-bundle [[name settings]]
  (println "generating config for " name)
  (package-json (:npm settings))
  (shadow-bundle name settings)
  )



(defn generate-config [name]
  (let [k (keyword name)]
  (generate-config-bundle [k (k bundle-config)])))

 ; (generate-config-bundle [:mariacloud (:mariacloud bundle-config)])
  ;(map generate-config-bundle bundle-config)
  




(comment

  (generate-config "small")

  (generate-config "mariacloud")
  
  
  )