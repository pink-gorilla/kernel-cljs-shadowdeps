(ns pinkgorilla.web
  (:require
   [clj-time.core :as t]
   [luminus.http-server :as http]
   [reitit.ring :as ring]
   [ring.util.http-response :as response]
   [ring.util.response :as res]
   [ring.middleware.content-type :refer [wrap-content-type]]

   [compojure.core :refer :all]
   [compojure.route :as route]

   [pinkgorilla.middleware :as middleware]
   [pinkgorilla.bundle-info :refer [available-bundles bundle-details]]
   )
 )

(defn summary []
  (str  "Available Bundles: " 
        (pr-str (available-bundles))
        (t/time-now)
        )
  )

(defn bundle-info [bundle]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (str 
          "Bundle Details " bundle "\n"
          (with-out-str (clojure.pprint/pprint (bundle-details bundle)))
          ;(pr-str (bundle-details bundle))
          )})



(defroutes handler
  (route/files "/out" {:root "out"})
  (GET "/" [] (summary))
  (GET "/info" [bundle] (bundle-info bundle))
  (GET "/test" [] {:status 200
                   :headers {"Content-Type" "text/plain"}
                   :body "Hello \nWorld"})
  (route/not-found "<h1>Page not found</h1>"))



(def app
  (middleware/wrap-middleware handler))


(defn run-web []
  (println "starting shadowdeps server at port 2705..")
  (http/start
   {:handler app
    :port 2705}))


(comment

  (run-web)
  
  )