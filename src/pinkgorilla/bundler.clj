(ns pinkgorilla.bundler
  (:require
   [clojure.pprint]
   [cheshire.core :as cheshire]
   [clojure.java.io :as io]))


(def bundle-root-dir "out/bundles") ;; relative to project dir
(def bundle-web-dir "../../public/bundles/") ;; relative to bundle-project-dir, example: out/bundles/gorilla


(defn- delete-recursively [fname]
  (let [func (fn [func f]
               (when (.isDirectory f)
                 (doseq [f2 (.listFiles f)]
                   (func func f2)))
               (clojure.java.io/delete-file f))]
    (func func (clojure.java.io/file fname))))

(defn- bundle-directory [bundle-name]
  (let [bundle-dir (str bundle-root-dir "/" bundle-name)]
    (when (not (.exists (io/file bundle-root-dir)))
      (.mkdir (java.io.File. bundle-root-dir)))
    (when (.exists (io/file bundle-dir))
      (delete-recursively bundle-dir))
    (.mkdir (java.io.File. bundle-dir))))


(defn- package-json [bundle-name npm-deps]
  (let [filename (str bundle-root-dir "/" bundle-name "/package.json")
        my-pretty-printer (cheshire/create-pretty-printer
                           (assoc cheshire/default-pretty-print-options
                                  :indent-arrays? true))
        npm-deps (assoc npm-deps "shadow-cljs" "^2.8.80")
        config {:dependencies npm-deps}]
    (spit filename (cheshire/generate-string config {:pretty my-pretty-printer}))))

(defn- shadow-bundle [bundle-name settings]
  (let [bundle-kw (keyword bundle-name)
        filename (str bundle-root-dir "/" bundle-name "/shadow-cljs.edn")
        ;deps (conj (:maven settings) ['thheller/shadow-cljs "2.8.80"])
        deps (vec (concat
                   [['thheller/shadow-cljs "2.8.80"]]
                   (:maven settings)))
        config {:dependencies deps
                :source-paths ["src"]
                :builds {bundle-kw {:target :bootstrap
                                    :output-dir (str bundle-web-dir bundle-name)
                                    :js-options {:minimize-require false}
                                    :exclude   (:exclude settings)
                                    :entries (:ns settings)}}}
        ;_ (println "shadow config: " config)
        ]
    (spit filename (with-out-str (clojure.pprint/pprint config)))))



(defn generate-config-bundle [name settings]
  (println "generating config for " name)
  (bundle-directory name)
  (package-json name (:npm settings))
  (shadow-bundle name settings))



