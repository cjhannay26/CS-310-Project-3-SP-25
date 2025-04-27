(ns Gracie1)

(defn member [var lizt]
    (cond
        (empty? lizt) false
        (= var (first lizt)) true 
        :else (member var rest(lizt)) 
    )
)

(defn append [lizt1 lizt2]
    (cond
        (empty? lizt1) lizt2
        :else (cons (first lizt1)
            (append (rest lizt1) lizt2))
    )
)