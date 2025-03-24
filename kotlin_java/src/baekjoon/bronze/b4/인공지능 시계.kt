package baekjoon.bronze.b4

import java.util.Calendar

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val cal = Calendar.getInstance().apply {
        this[Calendar.HOUR_OF_DAY] = input[0]
        this[Calendar.MINUTE] = input[1]
        this[Calendar.SECOND] = input[2]
    }
    cal.add(Calendar.SECOND, readln().toInt())
    println("${cal[Calendar.HOUR_OF_DAY]} ${cal[Calendar.MINUTE]} ${cal[Calendar.SECOND]}")
}