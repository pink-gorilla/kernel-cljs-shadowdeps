(ns pinkgorilla.bundle-info
  (:require
   [clojure.java.io :as io]
   [cognitect.transit :as transit]
   [clojure.string :as str]))

(defn available-bundles
  []
  (->> (io/file "./out/public/cljs-runtime")
       (.listFiles)
       (map #(.getName %))
       (doall)))

(defn bundle-details [bundle-name]
  (let [index-file-name (str "./out/public/cljs-runtime/" bundle-name "/index.transit.json")
        ;s (slurp index-file-name)
        in (io/input-stream index-file-name)
        reader (transit/reader in :json)]
    (transit/read reader)))

(comment

  (available-bundles)

  (bundle-details "gorilla")

  (with-out-str (clojure.pprint/pprint (bundle-details "gorilla")))

  ;comment end
  )