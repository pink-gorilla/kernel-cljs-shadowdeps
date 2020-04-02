(ns creator.config.gorilla)

(def gorilla
  {:maven [['cljs-ajax "0.8.0"] ; http requests
            ;; ['reagent "0.8.1"]
           ['thi.ng/strf "0.2.2"]
           ['org.pinkgorilla/gorilla-renderable "3.0.5"]
           ['org.pinkgorilla/gorilla-renderable-ui "0.1.25"]
           ['org.pinkgorilla/gorilla-ui "0.1.22"]
           ['awb99.fortune "0.0.2"]
           ['awb99/shapes "0.1.2"] ; shape library borrowed from maria-cloud
           ['quil "3.1.0"] ;drawing library
           ]
   :npm {"moment" "^2.24.0"
         "p5" "^0.9.0"  ; p5 is a quil cljsjs dependency, v 0.10.x has an error and cannot be used
         "react" "^16.12.0"
         "react-dom" "^16.12.0"
         "create-react-class" "^15.6.3"}
   :ns ['clojure.string
        'clojure.pprint
        'ajax.core   ; http requests
        'thi.ng.strf.core
          ; "react"
        'reagent.core
        ;'pinkgorilla.notebook.repl
         ; pinkgorilla CORE
         ;'pinkgorilla.ui.gorilla-renderable
         ;'pinkgorilla.ui.helper
        'pinkgorilla.ui.pinkie
         ;'pinkgorilla.shadow

         ; pinkgorilla.ui plugins
        'pinkgorilla.ui.default-renderer
        'pinkgorilla.ui.player  ; youtube/.. player
        'pinkgorilla.ui.sparklines  ; sparkline charts  
        'pinkgorilla.ui.aggrid  ; grids  
        'pinkgorilla.ui.leaflet ; geographic maps

         ; awb99 ui plugins
        'fortune.core
        'awb99.shapes.core

         ; general ui libraries
          ;'quil.sketch
        'quil.middleware
        'quil.core
          ; 'quil.util
        "p5"  ; p5 is a quil dependency ()p5 processingnet)

        "moment"]
   :exclude    #{'cljs.js}})