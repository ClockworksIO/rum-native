(defproject rum-native "0.1.0-SNAPSHOT"
  :description "A collection of components and tools to build React Native apps with Clojurescript "
  :url "https://github.com/ClockworksIO/rum-native"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure         "1.10.1"]
                 [org.clojure/clojurescript   "1.10.597"]
                 [riesling-core               "0.0.1-SNAPSHOT"]]
  :repl-options {:init-ns rum-native.core})
