# pliers

A tiny library that makes it easier to call anonymous functions from threading
macros. Inspired by `then` and `tap` in Elixir.

## Usage

The `pliers/then>` and `pliers/then>>` macros allow calling an anonymous
function from a threading macro, using its return value.

```clojure
user> (-> 1 (pliers/then> (fn [v] (< 0 v 2))))
true
user> (-> 1 (pliers/then> #(< 0 % 2)))
true
user> (->> 1 (pliers/then>> (fn [v] (< 0 v 2))))
true
user>> (->> 1 (pliers/then>> #(< 0 % 2)))
true
```

The `pliers/tee>` and `pliers/tee>>` macros allow calling an anonymous function
from a threading macro for its side effects, throwing away its return value.

```clojure
user> (-> 1 (pliers/tee> (fn [v] (println "My number is" v))))
My number is 1
1
user> (-> 1 (pliers/tee> #(println "My number is" %)))
My number is 1
1
user> (->> 1 (pliers/tee>> (fn [v] (println "My number is" v))))
My number is 1
1
user>> (->> 1 (pliers/tee>> #(println "My number is" %)))
My number is 1
1
```

## Development

Run the project's tests (they'll fail until you edit them):

    $ clojure -T:build test

Run the project's CI pipeline and build a JAR (this will fail until you edit the tests to pass):

    $ clojure -T:build ci

This will produce an updated `pom.xml` file with synchronized dependencies inside the `META-INF`
directory inside `target/classes` and the JAR in `target`. You can update the version (and SCM tag)
information in generated `pom.xml` by updating `build.clj`.

Install it locally (requires the `ci` task be run first):

    $ clojure -T:build install

Deploy it to Clojars -- needs `CLOJARS_USERNAME` and `CLOJARS_PASSWORD` environment
variables (requires the `ci` task be run first):

    $ clojure -T:build deploy

Your library will be deployed to dev.chrisodonnell/pliers on clojars.org by default.

## License

Copyright © 2023 Chris O'Donnell

Distributed under the MIT license
