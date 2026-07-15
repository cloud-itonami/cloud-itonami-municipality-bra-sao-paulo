(ns ordinance.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest sao-paulo-has-spec-basis
  (let [sb (facts/spec-basis "sao-paulo")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://legislacao.prefeitura.sp.gov.br/") sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "rio-de-janeiro")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["sao-paulo" "rio-de-janeiro"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["rio-de-janeiro"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["sao-paulo.decreto-53623-acesso-informacao"]
         (mapv :ordinance/id (facts/by-topic "sao-paulo" :transparency))))
  (is (empty? (facts/by-topic "sao-paulo" :labor)))
  (is (empty? (facts/by-topic "rio-de-janeiro" :governance))))
