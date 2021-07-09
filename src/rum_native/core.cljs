(ns rum-native.core
  ""
  (:require
   [rum-native.react :refer [ReactNative]]
   [rum-native.util :refer [create-element]]))

;;; React Native Non-UI Modules
(def Dimensions (.-Dimensions ReactNative))
(def Keyboard (.-Keyboard ReactNative))
(def Platform (.-Platform ReactNative))
(def UIManager (.-UIManager ReactNative))
(def AppState (.-AppState ReactNative))
(def NativeModules (.-NativeModules ReactNative))
(def DevSettings (.-DevSettings NativeModules))


;;; React Native Components
(def View (partial create-element (.-View ReactNative)))
(def SafeAreaView (partial create-element (.-SafeAreaView ReactNative)))
(def KeyboardAvoidingView (partial create-element (.-KeyboardAvoidingView ReactNative)))
(def ScrollView (partial create-element (.-ScrollView ReactNative)))
(def Text (partial create-element (.-Text ReactNative)))
(def Image (partial create-element (.-Image ReactNative)))
(def TextInput (partial create-element (.-TextInput ReactNative)))
(def Switch (partial create-element (.-Switch ReactNative)))
(def Button (partial create-element (.-Button ReactNative)))
(def Pressable (partial create-element (.-Pressable ReactNative)))
(def TouchableHighlight (partial create-element (.-TouchableHighlight ReactNative)))
(def TouchableOpacity (partial create-element (.-TouchableOpacity ReactNative)))
(def TouchableWithoutFeedback (partial create-element (.-TouchableWithoutFeedback ReactNative)))
(def Modal (partial create-element (.-Modal ReactNative)))
(def StatusBar (partial create-element (.-StatusBar ReactNative)))
(def ImageBackground (partial create-element (.-ImageBackground ReactNative)))
(def FlatList (partial create-element (.-FlatList ReactNative)))
(def SectionList (partial create-element (.-SectionList ReactNative)))
(def VirtualizedList (partial create-element (.-VirtualizedList ReactNative)))
