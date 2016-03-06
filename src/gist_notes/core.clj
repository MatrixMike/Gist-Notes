(ns gist-notes.core
  (:gen-class))

(require '[tentacles.users :as users])
(require '[tentacles.gists :as gists])
(require '[tentacles.repos :as repos])











(defn retrieve-gists [user_name password] ;this works
  (let [auth (str user_name ":" password)]
    (count (gists/gists {:auth auth}))
  )
)
;this works!
(defn get-public-gist [that-user user_name password]
  (let [auth (str user_name ":" password)]
    (loop [page 1 amnt 0] (let [gist-count (count (gists/user-gists that-user {:auth auth :per-page 100 :page page}))] (if (= 100 (count (gists/user-gists that-user {:auth auth :per-page 100 :page page}))) 
                                                                                                                         
                                                                                                                         (recur (+ page 1) (+ amnt 100))
                                                                                                                         (+ amnt gist-count))
       )
    )
  )
)











(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
