(ns Gracie2)

(defn append [lizt1 lizt2]
    (cond
        (empty? lizt1) lizt2
        :else (cons (first lizt1)
            (append (rest lizt1) lizt2))
    )
)
