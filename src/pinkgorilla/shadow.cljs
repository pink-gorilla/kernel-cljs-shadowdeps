(ns pinkgorilla.shadow
  (:require
   [clojure.string]
   ;[shadow.cljs.devtools.client.browser :refer [do-js-requires]]
    ;"shadow.js"
   ))

(defn add [a b]
  (+ a b))

(defn test! []
  (.log js/console "hello, world!"))

(defn js-require! [lib]
  (.log js/console "jsRequire: " lib)
 ; (do-js-requires lib)
;  (shadow.js.jsRequire lib)
  )