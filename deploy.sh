#!/usr/bin/env bash

set -o errexit   # abort on nonzero exitstatus
set -o nounset   # abort on unbound variable
set -o pipefail  # don't hide errors within pipes

clojure -T:build ci

PASSWORD_ITEM="$(bw get item 21518857-4d61-456f-a723-aed200eb0b7a)"
CLOJARS_USERNAME="$(echo "${PASSWORD_ITEM}" | jq -r '.login.username')"
CLOJARS_PASSWORD="$(echo "${PASSWORD_ITEM}" | jq -r '.login.password')"

clojure -T:build deploy
