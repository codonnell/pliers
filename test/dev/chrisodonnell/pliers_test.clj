(ns dev.chrisodonnell.pliers-test
  (:require [clojure.test :refer [deftest is]]
            [dev.chrisodonnell.pliers :as sut]))

(deftest then>-symbol-test
  (is (= 1 (-> 0 (sut/then> inc)))))

(deftest then>-anon-fn-test
  (is (= 1 (-> 0 (sut/then> (fn [v] (inc v)))))))

(deftest then>-hash-anon-fn-test
  (is (= 1 (-> 0 (sut/then> #(inc %))))))

(deftest then>>-symbol-test
  (is (= 1 (->> 0 (sut/then>> inc)))))

(deftest then>>-anon-fn-test
  (is (= 1 (->> 0 (sut/then>> (fn [v] (inc v)))))))

(deftest then>>-hash-anon-fn-test
  (is (= 1 (->> 0 (sut/then>> #(inc %))))))

(deftest tee>-symbol-test
  (is (= 0 (-> 0 (sut/tee> print))))
  (is (= "0" (with-out-str (-> 0 (sut/tee> print))))))

(deftest tee>-anon-fn-test
  (is (= 0 (-> 0 (sut/tee> (fn [v] (print v))))))
  (is (= "0" (with-out-str (-> 0 (sut/tee> (fn [v] (print v))))))))

(deftest tee>-hash-anon-fn-test
  (is (= 0 (-> 0 (sut/tee> #(print %)))))
  (is (= "0" (with-out-str (-> 0 (sut/tee> #(print %)))))))

(deftest tee>>-symbol-test
  (is (= 0 (->> 0 (sut/tee>> print))))
  (is (= "0" (with-out-str (->> 0 (sut/tee>> print))))))

(deftest tee>>-anon-fn-test
  (is (= 0 (->> 0 (sut/tee>> (fn [v] (print v))))))
  (is (= "0" (with-out-str (->> 0 (sut/tee>> (fn [v] (print v))))))))

(deftest tee>>-hash-anon-fn-test
  (is (= 0 (->> 0 (sut/tee>> #(print %)))))
  (is (= "0" (with-out-str (->> 0 (sut/tee>> #(print %)))))))
