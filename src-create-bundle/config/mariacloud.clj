(ns config.mariacloud)

(def mariacloud
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
       ;'pinkgorilla.shadow
       ]
  :exclude    #{'cljs.js}})