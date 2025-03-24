package baekjoon.silver.s5

import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val sdf = SimpleDateFormat("MMMM dd, yyyy HH:mm", Locale.US) // format December 31, 2007 23:59
    val date = sdf.parse(readLine()!!)
    val year = date.year + 1900

    val months = arrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val isLeap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)
    if (isLeap) months[1]++

    var totalDays = 0.0

    for (i in 0 until date.month) totalDays += months[i]

    totalDays += date.date - 1

    val totalMin = totalDays * 24 * 60 + date.hours * 60 + date.minutes
    val fullTimeMin = if (isLeap) 366 * 24 * 60 else 365 * 24 * 60

    println(totalMin.toDouble() / fullTimeMin.toDouble() * 100)
}