(ns rum-native.animated
  "React (Native) Animations."
  (:require
   [rum-native.react :refer [React ReactNative]]
   [rum-native.util :refer [create-element]]))


;;; Animations
(def useRef (.-useRef React))
(def useEffect (.-useEffect React))

(def Animated (.-Animated ReactNative))
(def AnimatedView (partial create-element (.-View Animated)))
(def AnimatedText (partial create-element (.-Text Animated)))
(def AnimatedValue (.-Value Animated))
(def AnimatedTiming (.-timing Animated))
(def AnimatedSpring (.-spring Animated))
(def ease (.-ease (.-Easing ReactNative)))
(def ease-out (.-out (.-Easing ReactNative)))
(def linear (.-linear (.-Easing ReactNative)))
(def bezier (.-bezier (.-Easing ReactNative)))

;; Layout Animation
(def LayoutAnimation (.-LayoutAnimation ReactNative))

;;; Mixins for RUM

(defn animation-mixin
  ""
  [key f initial]
  (letfn [(upds [state]
            (let [[_ value] (:rum/args state)]
              (.start (AnimatedTiming (key state)
                                      #js {:useNativeDriver true
                                           :toValue   (f value)
                                           :duration  200
                                           :easing    (ease-out ease)})
                      (fn [] (.info js/console "animation finished")))
              state))]
    {:init       (fn [state props]
                   (assoc state key (AnimatedValue. (f initial))))
     :will-mount   upds}))
     ;:did-mount   upds}))
