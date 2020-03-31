lein create-bundle-config small
cd out/bundles/small
yarn install
shadow-cljs -v release small
