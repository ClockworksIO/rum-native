(ns rum-native.fa
  ""
  (:require-macros [rum.core :refer [defc defcs]])
  (:require [rum.core :as rum]
            [rum-native.util :refer [create-element]]))

;;; Import FontAwesome JS Modules
(def FA (js/require "@fortawesome/react-native-fontawesome"))
(def FA-Core (js/require "@fortawesome/fontawesome-svg-core"))
(def FA-Solid (js/require "@fortawesome/free-solid-svg-icons"))
(def FA-Regular (js/require "@fortawesome/free-regular-svg-icons"))
(def FA-Brands (js/require "@fortawesome/free-brands-svg-icons"))

;;; Use solid, regular and brand icon (free only)
(def library (.-library FA-Core))
(.add library (.-fab FA-Brands)
              (.-far FA-Regular)
              (.-fas FA-Solid))

;;; Create RN RUM component to use icons
(def FontAwesomeIcon (partial create-element (.-FontAwesomeIcon FA)))


(defn icon
  ""
  ([icn] (icon icn {}))
  ([icn style] (FontAwesomeIcon (assoc style :icon icn))))



(comment
  "Use icons like: "
  (FontAwesomeIcon {:icon ["fas" "compass"]
                    :color "#ff0000"
                    :size 100}))

(comment
 "Add the following node modules:"
 "yarn add react-native-svg # **"
 "yarn add @fortawesome/fontawesome-svg-core"
 "yarn add @fortawesome/free-solid-svg-icons"
 "yarn add @fortawesome/react-native-fontawesome"
 "yarn add @fortawesome/free-regular-svg-icons"
 "yarn add @fortawesome/free-brands-svg-icons"

 "Don't forget to add the packages to the native modules in the `rum-natal.edn` file!")
