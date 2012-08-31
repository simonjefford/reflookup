(ns reflookup.core-test
  (:use clojure.test
        reflookup.core))

(def google_lookup { "example.com" {"referrer_id" 1}})

(deftest addreferral_simple
  (testing "adds a single piece of referral information to a 'simple' url"
    (is (= "http://example.com/?referrer_id=1"
           (add-referral "http://example.com" google_lookup)))))

(deftest addreferral_with_existing_query_string
  (testing "adds a single piece of referral information to a url with a query string"
    (is (= "http://example.com/?referrer_id=1&foo=1"
           (add-referral "http://example.com/?foo=1" google_lookup)))))

(def another_lookup { "example.com" {"referrer_id" 1 "bar" 42}})

(deftest addreferral_with_existing_query_string
  (testing "adds a single piece of referral information to a url with a query string"
    (is (= "http://example.com/?bar=42&referrer_id=1&foo=1"
           (add-referral "http://example.com/?foo=1" another_lookup)))))
