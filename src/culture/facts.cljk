(ns culture.facts
  "Regional-culture catalog for Sao Paulo -- local dishes, protected
  products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"sao-paulo"
   [{:culture/id "sao-paulo.dish.virado-a-paulista"
     :culture/name "Virado à paulista"
     :culture/municipality "sao-paulo"
     :culture/country "BRA"
     :culture/kind :dish
     :culture/summary "Complete meal from the state of São Paulo, Brazil; around 500,000 plates are served weekly in São Paulo city."
     :culture/url "https://en.wikipedia.org/wiki/Virado"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sao-paulo.dish.coxinha"
     :culture/name "Coxinha"
     :culture/municipality "sao-paulo"
     :culture/country "BRA"
     :culture/kind :dish
     :culture/summary "Brazilian snack of Paulista origin: chopped or shredded chicken covered in dough, molded into a teardrop shape, battered and fried; possibly originating in 19th-century Limeira, São Paulo."
     :culture/url "https://en.wikipedia.org/wiki/Coxinha"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sao-paulo.dish.pastel"
     :culture/name "Pastel"
     :culture/municipality "sao-paulo"
     :culture/country "BRA"
     :culture/kind :dish
     :culture/summary "Typical Brazilian street-food dish of thin-crust fried pies, traditionally sold in open-air marketplaces, with folklore origins tied to Japanese and Chinese influences in street markets."
     :culture/url "https://en.wikipedia.org/wiki/Pastel_(food)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sao-paulo.dish.feijoada"
     :culture/name "Feijoada"
     :culture/municipality "sao-paulo"
     :culture/country "BRA"
     :culture/kind :dish
     :culture/summary "Bean stew with beef or pork that became Brazil's national dish by the 19th century, typically served on Saturday; widely eaten in São Paulo."
     :culture/url "https://en.wikipedia.org/wiki/Feijoada"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sao-paulo.beverage.caipirinha"
     :culture/name "Caipirinha"
     :culture/municipality "sao-paulo"
     :culture/country "BRA"
     :culture/kind :beverage
     :culture/summary "Brazil's national cocktail of cachaça, sugar and lime, originating in the 19th century in the interior of the state of São Paulo, invented by landowning farmers in Piracicaba."
     :culture/url "https://en.wikipedia.org/wiki/Caipirinha"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sao-paulo.festival.virada-cultural"
     :culture/name "Virada Cultural"
     :culture/municipality "sao-paulo"
     :culture/country "BRA"
     :culture/kind :festival
     :culture/summary "24-hour cultural festival held annually, usually in May, in the city of São Paulo since 2005, with live music, films, plays and art exhibits; described as the biggest 24-hour festival in the world."
     :culture/url "https://en.wikipedia.org/wiki/Virada_Cultural"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sao-paulo.festival.sao-paulo-art-biennial"
     :culture/name "São Paulo Art Biennial"
     :culture/name-local "Bienal de São Paulo"
     :culture/municipality "sao-paulo"
     :culture/country "BRA"
     :culture/kind :festival
     :culture/summary "Biennial contemporary-art exhibition held in São Paulo since 1951, the third-oldest art biennial in the world after Venice and Menton."
     :culture/url "https://en.wikipedia.org/wiki/S%C3%A3o_Paulo_Art_Biennial"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sao-paulo.heritage.patio-do-colegio"
     :culture/name "Pátio do Colégio"
     :culture/municipality "sao-paulo"
     :culture/country "BRA"
     :culture/kind :heritage
     :culture/summary "Historical Jesuit site marking where the city of São Paulo was founded in 1554 with the inaugural mass of the Jesuit school."
     :culture/url "https://en.wikipedia.org/wiki/P%C3%A1tio_do_Col%C3%A9gio"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sao-paulo.heritage.sao-paulo-museum-of-art"
     :culture/name "São Paulo Museum of Art"
     :culture/name-local "Museu de Arte de São Paulo Assis Chateaubriand"
     :culture/municipality "sao-paulo"
     :culture/country "BRA"
     :culture/kind :heritage
     :culture/summary "Art museum in São Paulo founded in 1947, known for its architecturally significant 1968 concrete-and-glass headquarters by Lina Bo Bardi on Avenida Paulista."
     :culture/url "https://en.wikipedia.org/wiki/S%C3%A3o_Paulo_Museum_of_Art"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sao-paulo.heritage.municipal-market"
     :culture/name "Municipal Market of São Paulo"
     :culture/name-local "Mercadão"
     :culture/municipality "sao-paulo"
     :culture/country "BRA"
     :culture/kind :heritage
     :culture/summary "Public market of the city of São Paulo, known as the Mercadão, located on Rua da Cantareira."
     :culture/url "https://en.wikipedia.org/wiki/Municipal_Market_of_S%C3%A3o_Paulo"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-bra-sao-paulo culture catalog "
                 "(ADR-2607171400): " (count (get catalog "sao-paulo"))
                 " São Paulo entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
