(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest sao-paulo-has-culture-basis
  (let [sb (facts/spec-basis "sao-paulo")]
    (is (= 10 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "sao-paulo" (:culture/municipality %)) sb))
    (is (every? #(= "BRA" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "rio-de-janeiro")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["sao-paulo" "rio-de-janeiro"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["rio-de-janeiro"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 4 (count (facts/by-kind "sao-paulo" :dish))))
  (is (= ["sao-paulo.beverage.caipirinha"]
         (mapv :culture/id (facts/by-kind "sao-paulo" :beverage))))
  (is (empty? (facts/by-kind "sao-paulo" :craft)))
  (is (empty? (facts/by-kind "rio-de-janeiro" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
