package terra.scraper.util

import org.junit.Test
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.test.assertEquals

internal class DateUtilsTest {

    @Test
    fun `can parse german date`() {
        val input = "Do, 03. Dez 20 17:34"

        val expected = LocalDateTime.of(2020, Month.DECEMBER, 3, 17, 34)
        val actual = DateUtils.parseDeDate(input)

        assertEquals(expected, actual)
    }

    @Test
    fun foo() {
        val pattern = "EE, dd. MMM YY HH:mm"
        val formatter = DateTimeFormatter.ofPattern(pattern).withLocale(Locale.GERMAN)
        val expected = LocalDateTime.of(2020, Month.DECEMBER, 3, 17, 34)
        println(formatter.format(expected))
    }


}