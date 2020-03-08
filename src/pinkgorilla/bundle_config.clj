(ns pinkgorilla.bundle-config)

(def bundle-config
  {:small
   {:maven [['awb99.fortune "0.0.2"]
            ['reagent "0.8.1"]
            ;['org.pinkgorilla/gorilla-ui-sparklines "0.0.5"]
            ]
    :npm {"moment" "^2.24.0"
          "react" "^16.12.0"
          "react-dom" "^16.12.0"
          "create-react-class" "^15.6.3"}
    :ns ['fortune.core
         "moment"
         'pinkgorilla.shadow
         ;'pinkgorilla.ui.sparklines
         ]
    :exclude    #{'cljs.js}}
   :gorilla
   {:maven [['cljs-ajax "0.8.0"] ; http requests
            ;; ['reagent "0.8.1"]
            ['org.pinkgorilla/gorilla-renderable "3.0.2"]
            ['org.pinkgorilla/gorilla-renderable-ui "0.1.5"]
            ['org.pinkgorilla/gorilla-ui "0.1.7-SNAPSHOT"]
            ['awb99.fortune "0.0.2"]
            ['awb99/shapes "0.1.2"] ; shape library borrowed from maria-cloud
            ['quil "3.1.0"] ;drawing library
            ]
    :npm {"moment" "^2.24.0"
          "p5" "^0.9.0"  ; p5 is a quil cljsjs dependency, v 0.10.x has an error and cannot be used
          "react" "^16.12.0"
          "react-dom" "^16.12.0"
          "create-react-class" "^15.6.3"
        ;  "path" "^0.12.7"
        ;  "react-flip-move" "^3.0.3"
        ;  "react-highlight.js" "^1.0.7"
        ;  "shake.js" "^1.2.2"
          }
    :ns ['clojure.string
         'clojure.pprint
         'ajax.core              ; http requests
             ; "react"
         'reagent.core

         ; pinkgorilla CORE
         ;'pinkgorilla.ui.gorilla-renderable
         ;'pinkgorilla.ui.helper
         'pinkgorilla.ui.pinkie
         ;'pinkgorilla.shadow

         ; pinkgorilla ui plugins
         'pinkgorilla.ui.default-renderer         
         'pinkgorilla.ui.player  ; youtube/.. player
         'pinkgorilla.ui.sparklines  ; sparkline charts  
         'pinkgorilla.ui.aggrid  ; grids  
         'pinkgorilla.ui.leaflet ; geographic maps


         ; awb99 ui plugins
         'fortune.core
         'awb99.shapes.core

         'thi.ng.strf.core

         ; general ui libraries
          ;'quil.sketch
         'quil.middleware
         'quil.core
          ; 'quil.util
         "p5"  ; p5 is a quil dependency ()p5 processingnet)

         "moment"]
    :exclude    #{'cljs.js}}
   :mariacloud
   {:maven [['awb99.fortune "0.0.2"]
            ['re-view "0.4.6"]
            ['lark/cells "0.1.5"]
            ['lark/tools "0.1.19"]
            ['maria/shapes "0.1.0"]
            ['thi.ng/geom "0.0.908"]]
    :npm  {"@braintripping/keypress.js" "github:braintripping/Keypress#4477249"
           "codemirror" "^5.30.0"
           "react" "^16.12.0"
           "react-dom" "^16.12.0"
           "shadow-cljs" "^2.8.80"
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
         'pinkgorilla.shadow]
    :exclude    #{'cljs.js}}})

