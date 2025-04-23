(ns Michael)

(defn map [fun lizt]
	(cond
		(empty?lizt) '()
		:else (cons (fun (first lizt))
			(map fun (rest lizt)))
		)
)

(defn same [lizt1 lizt2]
	(cond
		(empty? lizt1) (empty? lizt2)
		(empty? lizt2) false
		(= (first lizt1) (first lizt2))
			(same (rest lizt1) (rest lizt2))
		:else false
	)
)