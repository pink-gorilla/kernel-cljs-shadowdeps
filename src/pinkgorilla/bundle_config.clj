(ns pinkgorilla.bundle-config)


(def bundle-config
  {:small
   {:maven [['awb99.fortune "0.0.2"]]
    :npm {"moment" "^2.24.0"}
    :ns ['fortune.core "moment"]}
   :gorilla
   {:maven [['awb99.fortune "0.0.2"]
            ['awb99/shapes "0.1.2"] ; shape library borrowed from maria-cloud
            ['org.pinkgorilla/gorilla-renderable "2.1.2"]
            ['quil "3.1.0"] ;drawing library
            ['reagent "0.8.1"]
            ]
    :npm {"moment" "^2.24.0"
          "p5" "^0.9.0"  ; p5 is a quil cljsjs dependency, v 0.10.x has an error and cannot be used
          "react" "^16.12.0"
          "react-dom" "^16.0.0"
          "create-react-class" "^15.6.3"
          "bulma-extensions" "^6.2.7"
          "bulma-tooltip" "^2.0.2"
          "path" "^0.12.7"
          "react-flip-move" "^3.0.3"
          "react-highlight.js" "^1.0.7"
          "shake.js" "^1.2.2"
          }
    :ns ['clojure.string
         'clojure.pprint
         'fortune.core
         'awb99.shapes.core
         'pinkgorilla.ui.gorilla-renderable
         ;'pinkgorilla.ui - this brings up namespace not available error.
         ;'quil.sketch
        ; 'quil.middleware
         'quil.core
        ; 'quil.util
         "moment"
         "p5"
         "react"
         'reagent.core
         ]}
   :mariacloud
   {:maven [['awb99.fortune "0.0.2"]
            ['re-view "0.4.6"]
            ['lark/cells "0.1.5"]
            ['lark/tools "0.1.19"]
            ['maria/shapes "0.1.0"]
            ['thi.ng/geom "0.0.908"]]
    :npm  {"@braintripping/keypress.js" "github:braintripping/Keypress#4477249"
           "codemirror" "^5.30.0"
           "react" "^16.0.0"
           "react-dom" "^16.0.0"
           "shadow-cljs" "^2.8.76"
           "moment" "^2.24.0"}
    :ns ['fortune.core
         'cells.cell
         'cells.lib
         'shapes.core
         're-view.core
         're-view.hiccup.core
         'lark.value-viewer.core
         're-db.d
         're-db.patterns
         "moment"
         ;'thi.ng.geom.svg.core
         ]}})

