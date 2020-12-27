package terra.scraper

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import terra.scraper.page.Classified
import terra.scraper.page.SearchResultPage
import terra.scraper.util.DateUtils

class JSoupScraper {

    fun parseAds(location: URLRequest): SearchResultPage {
        val document = Jsoup.connect(location.url).get()

        val regularCol = document.select("div#maincol").first()
        val regularAds = parseColumn(regularCol)

        val premiumCol = document.select("div#rightcol").first()
        val premiumAds = parseColumn(premiumCol)

        val resultCount = parseResultCount(document)

        return SearchResultPage(resultCount, regularAds, premiumAds)
    }

    private fun parseColumn(columnDiv: Element): List<Classified> =
            columnDiv
                    .select("table.inserat")
                    .map(::parseAd)

    private fun parseAd(adTable: Element): Classified {
        val rows = adTable.select("tbody tr")
        val dateRow = rows[1]
        val dateStr = dateRow.select("td").textNodes().first().text().trim()
        val postedDate = DateUtils.parseDeDate(dateStr)

        val adBodyRow = rows[2]
        val adText = adBodyRow.select("div.inserat1 p").textNodes()
                .joinToString("\n") { it.text().trim() }

        return Classified(postedDate, adText)
    }

    private fun parseResultCount(document: Document): Int {
        val resultCount = document.select("span#number_results_displayline").text()
        return resultCount.split(" ").first().toInt()
    }

}