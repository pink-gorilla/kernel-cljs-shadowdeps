(ns config.core
   (:require 
    [config.gorilla :refer [gorilla]]
    [config.small :refer [small]]
    [config.mariacloud :refer [mariacloud]]))

(def bundle-config
  {:small small
   :gorilla  gorilla
   :mariacloud  mariacloud})

(defn get-config [name]
  (let [k (keyword name)]
    (k bundle-config)))