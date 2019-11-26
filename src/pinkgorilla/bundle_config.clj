(ns pinkgorilla.bundle-config)


(def bundle-config
  {:small
   {:maven [['awb99.fortune "0.0.1"]]
    :npm {"moment" "^2.24.0"}
    :ns ['fortune.core "moment"]}
   :gorilla
   {:maven [['org.pinkgorilla/gorilla-renderable "2.1.2"] 
            ['quil "3.1.0"] ;drawing library
            ['awb99/shapes "0.1.2"] ; shape library borrowed from maria-cloud
            ['awb99.fortune "0.0.1"]
            ]
    :npm {"moment" "^2.24.0"}
    :ns ['fortune.core
         'pinkgorilla.ui.gorilla-renderable
         ;'pinkgorilla.ui - this brings up namespace not available error.
         'quil.sketch 
         "moment"]}
   :mariacloud
   {:maven [['re-view "0.4.6"]
            ['lark/cells "0.1.5"]
            ['lark/tools "0.1.19"]
            ['maria/shapes "0.1.0"]
            ['thi.ng/geom "0.0.908"]]
    :npm  {"@braintripping/keypress.js" "github:braintripping/Keypress#4477249"
           "codemirror" "^5.30.0"
           "react" "^16.0.0"
           "react-dom" "^16.0.0"
           "shadow-cljs" "^2.0.41"}
    :ns ['cells.cell
         'cells.lib
         'shapes.core
         're-view.core
         're-view.hiccup.core
         'lark.value-viewer.core
         're-db.d
         're-db.patterns
         ;'thi.ng.geom.svg.core
         ]}})

