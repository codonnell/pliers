(ns dev.chrisodonnell.pliers)

(defmacro then>
  "Takes a value and an arity-1 function. Calls the function on the value,
  returning the result. Meant to be used in a thread-first macro like:

  (-> 1 (pliers/then> (fn [v] (< 0 v 2))))"
  [x f]
  (list f x))

(defmacro then>>
  "Takes a value and an arity-1 function. Calls the function on the value,
  returning the result. Meant to be used in a thread-last macro like:

  (->> 1 (pliers/then>> (fn [v] (< 0 v 2))))"
  [f x]
  (list f x))

(defmacro tee>
  "Takes a value and an arity-1 function. Calls the function on the value. Meant
  to be used in a thread-first macro like:

  (-> 1 (pliers/tee> println))"
  [x f]
  (list 'do (list f x) x))

(defmacro tee>>
  "Takes a value and an arity-1 function. Calls the function on the value,
  returning the original value. Meant to be used in a thread-last macro like:

  (->> 1 (pliers/tee>> println))"
  [f x]
  (list 'do (list f x) x))
