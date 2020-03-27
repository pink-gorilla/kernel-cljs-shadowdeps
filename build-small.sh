lein run bundle small
cd out/bundles/small
yarn install
shadow-cljs -v release small
