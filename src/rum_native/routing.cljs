(ns rum-native.routing
  ""
  (:require-macros [rum.core :refer [defc defcs]])
  (:require
   [rum-native.util :refer [deep-merge-with deep-merge]]))


(defn setup-routes
  ""
  [cfg]
  (let [config  (deep-merge {:statusbar? true
                             :colors     {:primary           "#ffffff"
                                          :primary-light     "#ffffff"
                                          :primary-dark      "#ffffff"
                                          :on-primary        "#000000"
                                          :secondary         "#ffffff"
                                          :secondary-light   "#ffffff"
                                          :secondary-dark    "#ffffff"
                                          :on-secondary      "#000000"
                                          :background        "#ffffff"}}
                            (:config cfg))
        routes       (into {}  (mapv (fn [[k r]] [k (deep-merge {:navigator  {:show? false
                                                                              :icon  :none
                                                                              :order 0}
                                                                 :type       :none
                                                                 :bar        {:title   [:blank]
                                                                              :menu    []}}
                                                                r)])
                                     (:routes cfg)))]
    {:config  config
     :routes  routes}))



(defn find-level
  [kw]
  (if-let [nsp  (namespace kw)]
    (+ 1 (count (re-seq #"\." nsp)))
    0))
