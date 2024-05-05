package baekjoon.bronze.b3

import java.time.LocalDate

fun main() {
    val (year, month, day) = readln().split("-").map { it.toInt() }
    var nDay = day + readln().toInt()
    var nMonth = month + ((nDay - 1) / 30)
    nDay = (nDay - 1) % 30 + 1
    val nYear = year + ((nMonth - 1) / 12)
    nMonth = (nMonth - 1) % 12 + 1
    println(LocalDate.of(nYear, nMonth, nDay))
}
