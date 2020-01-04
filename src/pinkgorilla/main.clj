(ns pinkgorilla.main
  (:require
   [pinkgorilla.web :refer [run-web]]
   [pinkgorilla.bundler :refer [generate-config]])
  (:gen-class))

(defn -main [& args]
  (let [job (first args)
        symbol (second args)]
    (println "Kernel-CLJS ShadowDeps.")
    (println "Commandline Arguments: " args)
    (case job
      "bundle" (generate-config symbol)
      "web" (run-web))))