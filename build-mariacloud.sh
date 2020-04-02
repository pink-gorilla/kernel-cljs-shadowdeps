lein create-bundle-config mariacloud
cd out/bundles/mariacloud
npm install
./node_modules/.bin/shadow-cljs -v release mariacloud
