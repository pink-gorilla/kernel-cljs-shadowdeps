(ns bundle-server.main
  (:require
   [bundle-server.web :refer [run-web]])
  (:gen-class))

(defn -main [& args]
  (run-web))