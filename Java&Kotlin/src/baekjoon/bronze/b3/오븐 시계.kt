package baekjoon.bronze.b3

import java.util.Calendar

fun main() {
    val times = readLine()!!.split(" ").map { it.toInt() }
    val cal = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, times[0])
        set(Calendar.MINUTE, times[1])
    }
    cal.add(Calendar.MINUTE, readLine()!!.toInt())
    println("${cal[Calendar.HOUR_OF_DAY]} ${cal[Calendar.MINUTE]}")
}