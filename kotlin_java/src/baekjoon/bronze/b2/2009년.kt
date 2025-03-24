package baekjoon.bronze.b2

import java.time.LocalDate

fun main() {
    val (d, m) = readln().split(" ").map { it.toInt() }
    println(LocalDate.of(2009, m, d).dayOfWeek.toString().lowercase().replaceFirstChar { it.uppercase() })
}