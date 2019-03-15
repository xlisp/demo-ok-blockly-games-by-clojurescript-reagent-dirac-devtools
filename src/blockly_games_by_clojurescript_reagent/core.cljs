(ns blockly-games-by-clojurescript-reagent.core
  (:require
   [reagent.core :as reagent :refer [atom]]
   [Blockly]
   [Blockly.Blocks.loops]
   [Blockly.Blocks.lists]
   [Blockly.Blocks.texts]
   [Blockly.Blocks.procedures]
   [Blockly.Blocks.math]
   [Blockly.Blocks.variables]
   [Blockly.Blocks.colour]
   [Blockly.Blocks.logic]
   [Blockly.Msg.en]
   ))

;;(js/autosize (.querySelector js/document "textarea"))

(enable-console-print!)

(println "This text is printed from src/blockly-games-by-clojurescript-reagent/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))


(defn hello-world []
  [:div
   [:h1 (:text @app-state)]
   [:h3 "Edit this and watch it change!"]])

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
