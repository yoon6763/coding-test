package baekjoon.silver.s3

import java.util.Calendar

fun main() {
    val targetYear = readln().toInt()
    var cnt = 0
    val day = Calendar.getInstance().apply { set(2019, 0, 13) }
    while (day.get(Calendar.YEAR) <= targetYear) {
        if (day.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) cnt++
        day.add(Calendar.MONTH, 1)

    }
    println(cnt)
}