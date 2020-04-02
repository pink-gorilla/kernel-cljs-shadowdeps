(ns bundle-server.web
  (:require
   [clojure.string]
   [clojure.pprint]
   [clj-time.core :as t]
   [luminus.http-server :as http]
   [reitit.ring :as ring]
   [ring.util.http-response :as response]
   [ring.util.response :as res]
   [ring.middleware.content-type :refer [wrap-content-type]]

   [compojure.core :refer :all]
   [compojure.route :as route]
 [creator.main]
   [bundle-server.middleware :refer [wrap-middleware]]
   [bundle-server.bundle-info :refer [available-bundles bundle-details]]))

(defn bundle-link [bundle]
  (str "<br/> <a href='/info?bundle=" bundle "'> " bundle "</a>"))

(defn index-link [bundle]
  (str " <a href='/bundles/" bundle "/index.transit.json'> index-raw </a> <br/>"))

(defn bundle-row[bundle]
  (str (bundle-link bundle) (index-link bundle)))

(defn summary []
  (str  "Available Bundles: "
        (clojure.string/join " \n" (map bundle-row (available-bundles)))
   ;     (pr-str (available-bundles))
        "<br/>"
        (t/time-now)))

(defn bundle-info [bundle]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (str
          "Bundle Details " bundle "\n"
          (with-out-str (clojure.pprint/pprint (bundle-details bundle)))
          ;(pr-str (bundle-details bundle))
          )})

  (route/files "/foo" {:root "test/test_files"})

(defroutes handler
  (route/files "/bundles" ; mount point 
               {:root creator.main/bundle-web-dir } ; local dir
               )
  (GET "/" [] (summary))
  (GET "/info" [bundle] (bundle-info bundle))
  (GET "/test" [] {:status 200
                   :headers {"Content-Type" "text/plain"}
                   :body "Hello \nWorld"})
  (route/not-found "<h1>Page not found</h1>"))

(def app
  (wrap-middleware handler))

(defn run-web []
  (println "bundle-server starting at http://localhost:2705/ ..")
  (http/start
   {:handler app
    :port 2705})
   (println "bundle-server starting at http://localhost:2705/ ..")
  )

(comment

  (run-web))