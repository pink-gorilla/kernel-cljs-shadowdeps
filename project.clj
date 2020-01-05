(defproject org.pinkgorilla/kernel-cljs-shadowdeps "0.0.5"

  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :resource-paths ["out"]
  :deploy-repositories [["releases" {:url "https://clojars.org/repo"
                                     :username :env/release_username
                                     :password :env/release_password
                                     :sign-releases false}]]
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [clj-time "0.11.0"]
                 [compojure "1.6.1"]
                 [cheshire "5.8.0"]                                       ; JSON encoding
                 [amalloy/ring-gzip-middleware "0.1.4"]                   ; gzip compress responses
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-codec "1.1.1"]
                 [ring-cors "0.1.12"]                                     ; CORS requests
                 
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
   ;[thheller/shadow-cljs "2.8.80"]
                 
                 [com.cognitect/transit-clj "0.8.319"]                    ; load index transit files
                 ]
  :main ^:skip-aot pinkgorilla.main
  
  :profiles {:dev {:dependencies [;; [thheller/shadow-cljs "2.8.80"]
                                  ;; [thheller/shadow-cljsjs "0.0.21"]
                                  [clj-kondo "2019.11.23"]]
                   :plugins      [[lein-cljfmt "0.6.6"]
                                  [lein-cloverage "1.1.2"]]
                   :aliases      {"clj-kondo" ["run" "-m" "clj-kondo.main"]}
                   :cloverage    {:codecov? true
                                  ;; In case we want to exclude stuff
                                  ;; :ns-exclude-regex [#".*util.instrument"]
                                  ;; :test-ns-regex [#"^((?!debug-integration-test).)*$$"]
                                  }
                   ;; TODO : Make cljfmt really nice : https://devhub.io/repos/bbatsov-cljfmt
                   :cljfmt       {:indents {as->                [[:inner 0]]
                                            with-debug-bindings [[:inner 0]]
                                            merge-meta          [[:inner 0]]
                                            try-if-let          [[:block 1]]}}}
             :cljs {:plugins    [["lein-shell" "0.5.0"]]
                    :aliases    {"bundle-gorilla"         ["run" "bundle" "gorilla"]
                                 "shadow-release-gorilla" ["shell" "./node_modules/.bin/shadow-cljs" "-v" "release" "gorilla"]}
                    ;; :aliases {"build-gorilla" ["shell" "./build-gorilla.sh"]}
                    :prep-tasks ["bundle-gorilla"
                                 "shadow-release-gorilla"]}}
  ;; :prep-tasks ["build-shadow-ci"]
  
  :aliases {;; "build-shadow-ci" ["run" "-m" "shadow.cljs.devtools.cli" "compile" ":ci"]
            "bump-version" ["change" "version" "leiningen.release/bump-version"]}

  :release-tasks [["vcs" "assert-committed"]
                  ["bump-version" "release"]
                  ["vcs" "commit" "Release %s"]
                  ["vcs" "tag" "v" "--no-sign"]
                  ["deploy"]
                  ["bump-version"]
                  ["vcs" "commit" "Begin %s"]
                  ["vcs" "push"]])
