package terra.scraper

import com.github.kristofa.test.http.Method
import com.github.kristofa.test.http.MockHttpServer
import com.github.kristofa.test.http.SimpleHttpResponseProvider
import org.apache.http.entity.ContentType
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import terra.TestResources
import terra.scraper.page.Classified
import terra.scraper.util.DateUtils
import kotlin.test.assertEquals

val DEFAULT_PORT = 8090

class MockHttpTest {

    companion object {

        val responseProvider = SimpleHttpResponseProvider()
        val server: MockHttpServer = MockHttpServer(DEFAULT_PORT, responseProvider)

        @BeforeClass
        @JvmStatic
        fun startServer() {
            server.start()
        }

        @AfterClass
        @JvmStatic
        fun stopServer() {
            server.stop()
        }
    }

    @Test
    fun `basic scraping test case`() {
        val html = TestResources.resourceAsStringRelativeTo("basicCase.html", this.javaClass)
        responseProvider
                .expect(Method.GET, "/")
                .respondWith(200, ContentType.TEXT_HTML.mimeType, html)

        // FIXME: it's very difficult to expect a POST request with HTTP mocking library
        val scraper = object : JSoupScraper() {
            override fun fetchDocument(url: String): Document =
                    Jsoup.connect(url).get()
        }
        val page = scraper.parseAds(LocalListClassifiedsRequest())
        assertEquals(313, page.totalResults)
        assertEquals(20, page.classifieds.size)
        assertEquals(10, page.premiumClassifieds.size)

        val firstAd = Classified(DateUtils.parseDeDate("So, 27. Dez 20 12:50"),
                "I am looking for :\n" +
                        "1,0 Bothrops bilineatus\n" +
                        "0,1 Tropidolaemus wagleri from Malaysia\n" +
                        "1,0 Trimeresurus puniceus\n" +
                        "0,1 Atheris squamigera (only interesting colors, red,\n" +
                        "black, tigers, dark blue etc.)\n" +
                        "\n" +
                        "wagleri@email.cz")
        assertEquals(firstAd, page.classifieds.first())

        val lastAd = Classified(DateUtils.parseDeDate("Do, 03. Dez 20 14:54"),
                "I offer these Boa constrictor 2020-the first RC pastel breeding in Europe\n" +
                        "1.0 VPI RLT Jungle Pink panth, RC pastel\n" +
                        "1.0 Rosley VPI, Pink panther, RC pastel\n" +
                        "0.1 VPI Jungle, Pink panther, RC pastel\n" +
                        "1.0 VPI Jungle Pink panther, RC pastel\n" +
                        "1.0 VPI Pink panther, RC pastel\n" +
                        "1.0 RLT Jungle hetero VPI, Pink panther, RC pastel\n" +
                        "2.0 hetero VPI Pink panther, RC pastel\n" +
                        "1,0 Motley VPI Pink Panther RC pastel\n" +
                        "Transportation from the Czech Republic, to Utrech and Amsterdam on December 11, 2020 is possible")
        assertEquals(lastAd, page.classifieds.last())

        val lastPremiumAd = Classified(DateUtils.parseDeDate("Mi, 11. Nov 20 07:21"),
                "Iguana iguana albino NZ 8/2020\n" +
                        "\n" +
                        "1,1 Hydrosaurus pustulatus NZ 2018")
        assertEquals(lastPremiumAd, page.premiumClassifieds.last())
    }

}

class LocalListClassifiedsRequest : URLRequest {

    override val url = "http://localhost:${DEFAULT_PORT}"

}