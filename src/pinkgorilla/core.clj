(ns pinkgorilla.core
  (:require
   [clj-time.core :as t]
   [luminus.http-server :as http]
   [reitit.ring :as ring]
   [ring.util.http-response :as response]
   [ring.util.response :as res]
   [ring.middleware.content-type :refer [wrap-content-type]]

   [compojure.core :refer :all]
   [compojure.route :as route]

   [pinkgorilla.middleware :as middleware])
  (:gen-class))


(defroutes handler
  (route/files "/out" {:root "out"})
  (GET "/" [] (str (t/time-now)))
  (route/not-found "<h1>Page not found</h1>"))



(def app
  (middleware/wrap-middleware handler))


(defn run-app []
  (println "starting shadowdeps server at port 2705..")
  (http/start
   {:handler app
    :port 2705}))



(defn -main []
  (run-app))




(comment

  (run-app)
  
  )