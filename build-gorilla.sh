lein create-bundle-config gorilla
cd out/bundles/gorilla
npm install
./node_modules/.bin/shadow-cljs -v release gorilla
