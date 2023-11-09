#!/usr/bin/env bash

set -o errexit   # abort on nonzero exitstatus
set -o nounset   # abort on unbound variable
set -o pipefail  # don't hide errors within pipes

clojure -T:build ci

export CLOJARS_USERNAME="codonnell"
export CLOJARS_PASSWORD="$(bw get notes 49c1ca81-3e50-4575-98e6-b0b5009a11f2)"

clojure -T:build deploy
