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
(defn get-public-gists [that-user user_name password]
  (let [auth (str user_name ":" password)]
    (loop [page 1 amnt 0] (let [gist-count (count (gists/user-gists that-user {:auth auth :per-page 100 :page page}))] (if (= 100 (count (gists/user-gists that-user {:auth auth :per-page 100 :page page}))) 
                                                                                                                         
                                                                                                                         (recur (+ page 1) (+ amnt 100))
                                                                                                                        (+ amnt gist-count))
       )
    )
  )
)

(defn get-public-gists-ids [that-user user_name password] ;retreives a list of gists by their id
  (let [auth (str user_name ":" password)]
    (loop [page 1 gist-ids []]
      (let [gists (gists/user-gists that-user {:auth auth :per-page 100 :page page})]
        (if (= 100 (count gists))
          (recur (+ page 1) (into gist-ids gists))
          (map :id (into gist-ids gists))
        )
      )
    )
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
