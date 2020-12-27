package terra.scraper.page

import java.time.LocalDateTime

class SearchResultPage(
        val totalResults: Int,
        val classifieds: List<Classified>,
        val premiumClassifieds: List<Classified>)


fun List<Classified>.mostRecentAdOnPage(): LocalDateTime =
        LocalDateTime.now()

fun List<Classified>.leastRecentAdOnPage(): LocalDateTime =
        LocalDateTime.now()
