(ns config.small)

(def small

{:maven [['awb99.fortune "0.0.2"]
         ['reagent "0.8.1"]]
 :npm {"moment" "^2.24.0"
       "react" "^16.12.0"
       "react-dom" "^16.12.0"
       "create-react-class" "^15.6.3"}
 :ns ['fortune.core
      "moment"]
 :exclude    #{'cljs.js}})
