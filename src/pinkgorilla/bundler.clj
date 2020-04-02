(ns pinkgorilla.bundler
  (:require
   [clojure.pprint]
   [cheshire.core :as cheshire]
   [clojure.java.io :as io]))

(defn- delete-recursively [fname]
  (let [func (fn [func f]
               (when (.isDirectory f)
                 (doseq [f2 (.listFiles f)]
                   (func func f2)))
               (clojure.java.io/delete-file f))]
    (func func (clojure.java.io/file fname))))

(defn- create-bundle-directory [config-dir bundle-name]
  (let [bundle-dir (str config-dir "/" bundle-name)]
    (when (not (.exists (io/file config-dir)))
      (.mkdir (java.io.File. config-dir)))
    (when (.exists (io/file bundle-dir))
      (delete-recursively bundle-dir))
    (.mkdir (java.io.File. bundle-dir))))

(defn- package-json [config-dir bundle-name npm-deps]
  (let [filename (str config-dir "/" bundle-name "/package.json")
        my-pretty-printer (cheshire/create-pretty-printer
                           (assoc cheshire/default-pretty-print-options
                                  :indent-arrays? true))
        npm-deps (assoc npm-deps "shadow-cljs" "^2.8.80")
        config {:dependencies npm-deps}]
    (spit filename (cheshire/generate-string config {:pretty my-pretty-printer}))))

(defn- shadow-bundle [config-dir bundle-dir bundle-name settings]
  (let [bundle-kw (keyword bundle-name)
        filename (str config-dir "/" bundle-name "/shadow-cljs.edn")
        ;deps (conj (:maven settings) ['thheller/shadow-cljs "2.8.80"])
        deps (vec (concat
                   [['thheller/shadow-cljs "2.8.80"]]
                   (:maven settings)))
        config {:dependencies deps
                :source-paths ["src"]
                :builds {bundle-kw {:target :bootstrap
                                    :output-dir (str bundle-dir bundle-name)
                                    :js-options {:minimize-require false}
                                    :exclude   (:exclude settings)
                                    :entries (:ns settings)}}}
        ;_ (println "shadow config: " config)
        ]
    (spit filename (with-out-str (clojure.pprint/pprint config)))))

(defn generate-config-bundle [config-dir bundle-dir name settings]
  (println "generating config for " name)
  (create-bundle-directory config-dir name)
  (package-json config-dir name (:npm settings))
  (shadow-bundle config-dir bundle-dir name settings))



