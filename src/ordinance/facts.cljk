(ns ordinance.facts
  "Municipal-ordinance compliance catalog for São Paulo -- the
  TWENTIETH municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo,
  -bel-brussels, -chl-santiago, -col-bogota, -cri-san-jose for the
  first nineteen) per ADR-2607141700 (cloud-itonami-compliance-fact-federation).
  São Paulo is Brazil's largest city but NOT its national capital
  (Brasília is) -- included on the same footing as other non-capital
  major-city entries in this family (Toronto, Sydney).

  Every entry cites an OFFICIAL legislacao.prefeitura.sp.gov.br
  (Catálogo de Legislação Municipal, the City of São Paulo's own
  official legislative catalog) URL -- never fabricated. An ordinance
  not in this table has NO spec-basis, full stop; extend `catalog`, do
  not invent an id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"sao-paulo"
   [{:ordinance/id "sao-paulo.lei-organica-municipio"
     :ordinance/title "Lei Orgânica do Município de São Paulo"
     :ordinance/municipality "sao-paulo"
     :ordinance/country "BRA"
     :ordinance/kind :ordinance
     :ordinance/number "Lei N.º 0"
     :ordinance/url "https://legislacao.prefeitura.sp.gov.br/leis/lei-0-de-04-de-abril-de-1990"
     :ordinance/url-provenance :official-legislacao-prefeitura-sp-gov-br
     :ordinance/enacted-date "1990-04-04"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance}}
    {:ordinance/id "sao-paulo.decreto-53623-acesso-informacao"
     :ordinance/title "Decreto N.º 53.623 (Regulamenta a Lei de Acesso à Informação no âmbito municipal)"
     :ordinance/municipality "sao-paulo"
     :ordinance/country "BRA"
     :ordinance/kind :ordinance
     :ordinance/number "Decreto N.º 53.623"
     :ordinance/url "https://legislacao.prefeitura.sp.gov.br/leis/decreto-53623-de-12-de-dezembro-de-2012"
     :ordinance/url-provenance :official-legislacao-prefeitura-sp-gov-br
     :ordinance/enacted-date "2012-12-12"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:transparency :information-disclosure}}]})

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
      :note (str "cloud-itonami-municipality-bra-sao-paulo Wave 0 (ADR-2607141700): "
                 (count (get catalog "sao-paulo")) " São Paulo entries seeded "
                 "with an official legislacao.prefeitura.sp.gov.br citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
