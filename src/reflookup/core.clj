(ns reflookup.core
  (:use [clojurewerkz.urly.core :only (host-of query-of)]
        [clojure.string :only [split join]]))

(defn add-referral [url params_lookup]
  (let [host (host-of url)
        additional (map (fn [kvp] (join "=" kvp)) (params_lookup host))]
    (str url "?" (join "&" additional))))
