(defproject org.pinkgorilla.kernel-cljs-shadowdeps "0.0.1"

  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :dependencies
  [[org.clojure/clojure "1.10.1"]


   [clj-time "0.11.0"]
   [compojure "1.6.1"]
   [cheshire "5.8.0"]                         ; JSON encoding
   [amalloy/ring-gzip-middleware "0.1.4"]     ; gzip compress responses
   [ring/ring-defaults "0.3.2"]
   [ring/ring-codec "1.1.1"]
   [ring-cors "0.1.12"]                       ; CORS requests
   
   [ch.qos.logback/logback-classic "1.2.3"]
   [cheshire "5.8.1"]
   [clojure.java-time "0.3.2"]
   [cprop "0.1.14"]
   [expound "0.7.2"]
   [funcool/struct "1.4.0"]
   [luminus-jetty "0.1.7"]
   [luminus-transit "0.1.1"]
   [luminus/ring-ttl-session "0.3.3"]
   [metosin/muuntaja "0.6.4"]
   [metosin/reitit "0.3.9"]
   [metosin/ring-http-response "0.9.1"]

   [org.clojure/tools.cli "0.4.2"]
   [ring/ring-core "1.7.1"]
   
   ; shadow-cljs is not needed here (we generate shadow deps via yarn)
   ;[thheller/shadow-cljs "2.0.40"]
   
   ]

  :min-lein-version "2.8.0"
  :source-paths ["src"]
  :test-paths ["test"]
  :resource-paths ["resources"]
  :target-path "target/%s/"
  :main ^:skip-aot pinkgorilla.main)
