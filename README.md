# Pink Gorilla ClojureScript kernel dependencies [![GitHub Actions status |pink-gorilla/kernel-cljs-shadowdeps](https://github.com/pink-gorilla/kernel-cljs-shadowdeps/workflows/CI/badge.svg)](https://github.com/pink-gorilla/kernel-cljs-shadowdeps/actions?workflow=CI)[![Clojars Project](https://img.shields.io/clojars/v/org.pinkgorilla/kernel-cljs-shadowdeps.svg)](https://clojars.org/org.pinkgorilla/kernel-cljs-shadowdeps)


# Library Usecase
  Use pinkgorilla.bundler to create a dyanamic configuration files, with which 
  shadow-cljs can build bundles.
  ```
   (pinkgorilla.bundler/generate-config-bundle bundle-name bundle-settings)
  ```

## How to run it:

```
  ; It is expected that you have shadow-cljs installed.

  ; build bundles:
  ./build-small.sh
  ./build-gorilla.sh
  ./builld-mariacloud.sh

  ; run the webserver that provides the bundles
  lein run-bundle-server
  this starts a server on port 2705.

```

## What happens

- Bundles are created in /out/small  /out/gorilla /out/mariacloud 
- Each Bundle has:
- index.transit.json - this file is used by shadow-cljs loader.
- ana/*.transit.json  - analysis files that are used by the self hosted clojurescript anlyzer
- js/*.js - compiled namespaces from npm and maven that will be read by the shdow-clj loader 
- src/*.* - source files (can be cljs or js) of the bundled namespaces.

## Advantages

- CLJS Kernel has no dependencies on the libraries that it exectutes


## Further Work:

- compile all namespaces for a dependency without specifying namespaces
- dont provide bundles, but serve on a per namespace basis
- allow multiple versions numbers for each library.
- dynamic on the fly compilation of dependencies via api

