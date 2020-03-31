lein create-bundle-config gorilla
cd out/bundles/gorilla
yarn install
shadow-cljs -v release gorilla
