package baekjoon.bronze.b5

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    var date = LocalDate.of(2024, 8, 1)
    repeat(readln().toInt() - 1) { date = date.plusMonths(7) }
    println(date.format(DateTimeFormatter.ofPattern("yyyy M")))
}