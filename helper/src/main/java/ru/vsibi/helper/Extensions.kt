package ru.vsibi.helper

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

val dateFormatter = SimpleDateFormat("dd.MM.yyyy");
val timeFormatter = SimpleDateFormat("HH:mm")


fun getTimestampFromDate(dateString : String) : Long?{
    return try {
        val date: Date = dateFormatter.parse(dateString)
        date.time
    } catch (e: ParseException) {
        e.printStackTrace()
        null
    }
}

fun getTimestampFromTime(dateString : String) : Long?{
    return try {
        val date: Date = timeFormatter.parse(dateString)
        date.time
    } catch (e: ParseException) {
        e.printStackTrace()
        null
    }
}

fun getDateFromTimestamp(dateLong : Long?) : String?{
    if(dateLong == null) return null
    return dateFormatter.format(dateLong)
}

fun getTimeFromTimestamp(timeLong : Long?) : String?{
    if(timeLong == null) return null
    return timeFormatter.format(timeLong)
}

fun getTodayDayOfWeek() : String{
    val sdf = SimpleDateFormat("EEEE")
    val d = Date()
    return sdf.format(d)
}

fun getToday(): String{
    val dateFormat =
        SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
    val d = Date()
    return dateFormat.format(d)
}