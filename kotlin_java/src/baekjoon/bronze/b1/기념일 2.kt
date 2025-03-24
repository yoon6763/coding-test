package baekjoon.bronze.b1

import java.text.SimpleDateFormat
import java.util.Date

fun main() {
    val (date, plus) = readln().split(" ")
    val (y, m, d) = date.split("-").map { it.toInt() }
    print(SimpleDateFormat("yyyy-MM-dd").format(Date(y - 1900, m - 1, d + plus.toInt() - 1)))
}