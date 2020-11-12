(ns rum-native.android
  ""
  (:require
   [rum-native.react :refer [React ReactNative]]
   [riesling-core.cljs.log :refer [push!]]))


;;; Android specific UI Components

;;; Android specific non-UI Modules
(def BackHandler (.-BackHandler ReactNative))


;;; Mixins for RUM

(def android-backbutton
  "Rum mixin to support the backbutton on Android for navigation.

  This rum mixin adds an event listener for Android devices to be able to navigate
  one screen back when a user presses the back button.

  If the current ui state has a parent state, then the parent ui state will get
  restored. If there is no parent state, the app is closed."
  { :did-mount    (fn [state]
                    (.addEventListener BackHandler
                                       "hardwareBackPress"
                                       (fn [x]
                                           (let [log  (first (:rum/args state))]
                                              (push! log [[:r.fn.ui/pop]])
                                              true)))
                    state)
    :will-unmount (fn [state]
                    (.removeEventListener BackHandler "hardwareBackPress")
                    state)})
