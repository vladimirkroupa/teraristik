package terra.scraper.util

import java.time.LocalDateTime

import java.time.format.DateTimeFormatter
import java.util.*

object DateUtils {

    private val pattern = "EE dd. MMM yy HH:mm"
    private val formatter = DateTimeFormatter.ofPattern(pattern).withLocale(Locale.GERMAN)

    fun parseDeDate(dateTime: String): LocalDateTime =
            LocalDateTime.parse(fixDayOfWeekFullStop(fixMonthFullStop(dateTime)), formatter)

    private fun fixDayOfWeekFullStop(dateTime: String) =
            dateTime.replace(',', '.')

    private fun fixMonthFullStop(dateTime: String) =
            dateTime.replace(Regex("([A-Z][a-z][a-z])")) { it.value + "." }


}
