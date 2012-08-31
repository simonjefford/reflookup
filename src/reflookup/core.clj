(ns reflookup.core
  (:use [clojurewerkz.urly.core :only (host-of query-of url-like)]
        [clojure.string :only [split join]]))

(defn add-referral [url params_lookup]
  (let [url (url-like url)
        host (host-of url)
        query [(query-of url)]
        additional (map (fn [kvp] (join "=" kvp)) (params_lookup host))]
    (str (.withoutQuery url) "?" (join "&" (filter identity (concat additional query))))))

(comment

(def google_lookup { "example.com" {"referrer_id" 1}})
(add-referral "http://example.com?foo=1" google_lookup)
(add-referral "http://example.com" google_lookup)

)
