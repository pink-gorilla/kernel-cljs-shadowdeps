(ns bundle-server.bundle-info
  (:require
   [clojure.java.io :as io]
   [cognitect.transit :as transit]
   [clojure.string]
   [creator.main]
   ))


;(def bundle-web-dir "./out/public/bundles")


(defn available-bundles
  []
  (->> (io/file creator.main/bundle-web-dir)
       (.listFiles)
       (map #(.getName %))
       (doall)))

(defn bundle-details [bundle-name]
  (let [index-file-name (str creator.main/bundle-web-dir "/" bundle-name "/index.transit.json")
        ;s (slurp index-file-name)
        in (io/input-stream index-file-name)
        reader (transit/reader in :json)]
    (transit/read reader)))

(defn bundle-link [bundle-name]
  (str "bundles/" bundle-name "/index.transit.json"))

(comment

  (available-bundles)

  (bundle-details "gorilla")

  (with-out-str (clojure.pprint/pprint (bundle-details "gorilla")))

  ;comment end
  )