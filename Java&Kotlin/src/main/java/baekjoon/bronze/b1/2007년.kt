package baekjoon.bronze.b1

import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val line = readLine()!!.split(" ").map { it.toInt() }
    val cal = Calendar.getInstance().apply {
        this[Calendar.YEAR] = 2007
        this[Calendar.MONTH] = line[0] - 1
        this[Calendar.DAY_OF_MONTH] = line[1]
    }
    println(SimpleDateFormat("E", Locale.US).format(cal.timeInMillis).uppercase())
}