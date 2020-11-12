(ns rum-native.react)

;;; IMPORT REACT
(set! js/window.React (js/require "react"))


;;; Import Javascript modules and define Clojurescript abstractions to use them

(def React
  "React javascript module."
  (js/require "react"))

(def ReactNative
 "React-Native Javascript module."
 (js/require "react-native"))


(def create-class
  "Create a react class.
  **Important:** Starting from _react-native 0.63.0_ this is no longer included in the react
                 Javascript module and must be imported as extra module in the JS package!"
  (js/require "create-react-class"))
