(defn member [var lizt]
    (cond
        (empty? lizt) false
        (= var (first lizt)) true 
        :else (member var rest(lizt)) 
    )
)
