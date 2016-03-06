(ns gist-notes.core
  (:gen-class))

(require '[tentacles.users :as users])
(require '[tentacles.gists :as gists])
(require '[tentacles.repos :as repos])







(defn retrieve-gists [user_name] ;please use auth 
  (count (gists/user-gists user_name {:per-page 100}))














)










(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
