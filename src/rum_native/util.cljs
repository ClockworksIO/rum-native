(ns rum-native.util
  "Utilities for React Native and rum as a react wrapper."
  (:require [rum-native.react :refer [React ReactNative create-class]]))

;; create a factory for the react root component
(def create-factory (.-createFactory React))

;;; REACT NATIVE APP SETUP UTILS

;; App mounting
(defonce root-component (atom nil))
(defonce mounted-element (atom nil))

(defn make-root-component-factory
  "Returns a React Native component factory fn for the root component singleton."
  []
  (create-factory
    (create-class
      #js {:getInitialState (fn []
                              (this-as this
                                (if-not @root-component
                                  (reset! root-component this)
                                  (throw (js/Error. "ASSERTION FAILED: re-natal.support root component mounted more than once.")))))
           :render          (fn [] @mounted-element)})))

(defn mount
  "A modified version of rum.core/mount to work with React Native and rum-natal.

  Since React Native's root component is a singleton, mount doesn't apply in the context of a DOM element (like in React),
  but applies globally to the app. This function mounts/replaces the current "
  [element]
  (reset! mounted-element element)
  (when @root-component
    (.forceUpdate @root-component)))

(defn create-element
  "Create a new react element useable by clojure/rum from a react native js component."
  [rn-comp opts & children]
  (apply js/React.createElement rn-comp (clj->js opts) children))
