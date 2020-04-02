lein create-bundle-config small
cd out/bundles/small
npm install
./node_modules/.bin/shadow-cljs -v release small
