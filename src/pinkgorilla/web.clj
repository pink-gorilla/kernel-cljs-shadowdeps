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


(defn bundle-link [bundle]
  (str "<br/> <a href='/info?bundle=" bundle "'> " bundle "</a>"))

(defn summary []
  (str  "Available Bundles: " 
        (clojure.string/join " \n" (map bundle-link (available-bundles)))
   ;     (pr-str (available-bundles))
        "<br/>"
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
  (route/files "/out/public/cljs-runtime" {:root "out/public/cljs-runtime"})
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