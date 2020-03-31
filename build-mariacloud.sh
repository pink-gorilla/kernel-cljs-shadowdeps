lein create-bundle-config mariacloud
cd out/bundles/mariacloud
yarn install
shadow-cljs -v release mariacloud
