package baekjoon.bronze.b4

import java.time.LocalDate

fun main() {
    val (y, m, d) = readln().split("-").map { it.toInt() }
    println(if (LocalDate.of(2023, 10, 21).minusDays(34).isAfter( LocalDate.of(y, m, d))) "GOOD" else "TOO LATE")
}