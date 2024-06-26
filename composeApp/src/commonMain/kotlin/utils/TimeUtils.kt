package utils

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.UtcOffset
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.format
import kotlinx.datetime.toLocalDateTime

fun String.formatTimeToPublishedDate() = buildString {
    val dateTime = Instant.parse(this@formatTimeToPublishedDate)
        .toLocalDateTime(TimeZone.currentSystemDefault())

    append("Published on ")

    append(DateTimeComponents.Formats.RFC_1123.format {
        setDateTime(dateTime)
        setOffset(UtcOffset.ZERO)
    })

//    date.toInstant(TimeZone.currentSystemDefault()).format(
//    })
//    append("${dateTime.format()}")
//    append("${dateTime.hour}:${dateTime.minute} on ")
//    append("${dateTime.dayOfMonth}/${dateTime.month}/${dateTime.year.absoluteValue}".toLowerCase(Locale.current))
}