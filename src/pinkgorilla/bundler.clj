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
        npm-deps (assoc npm-deps "shadow-cljs" "^2.8.80")
        config {:dependencies npm-deps}]
    (spit filename (generate-string config {:pretty my-pretty-printer}))))


(defn shadow-bundle [bundle-name settings]
  (let [filename "shadow-cljs.edn"
        ;deps (conj (:maven settings) ['thheller/shadow-cljs "2.8.80"])
        deps (vec (concat
                   [['thheller/shadow-cljs "2.8.80"]]
                   (:maven settings)))
        config {:dependencies deps
                :source-paths ["src"]
                :builds {bundle-name {:target :bootstrap
                                      :output-dir (str "out/public/cljs-runtime/" (name bundle-name))
                                      :js-options {:minimize-require false }
                                      :exclude   (:exclude settings)
                                      :entries (:ns settings)}}}
        _ (println "shadow config: " config)]
    (spit filename (with-out-str (clojure.pprint/pprint config)))))


;(defn shadow-cljs [config]
;  {:builds (reduce shadow-bundle {} config)})



(defn generate-config-bundle [[name settings]]
  (println "generating config for " name)
  (package-json (:npm settings))
  (shadow-bundle name settings))



(defn generate-config [name]
  (let [k (keyword name)]
    (generate-config-bundle [k (k bundle-config)])))

 ; (generate-config-bundle [:mariacloud (:mariacloud bundle-config)])
  ;(map generate-config-bundle bundle-config)





(comment

  (generate-config "small")

  (generate-config "mariacloud"))