package baekjoon.bronze.b3

import java.time.LocalDate

fun main() {
    repeat(readln().toInt()) {
        val (year, m) = readln().split(" ").map { it.toInt() }
        val date = LocalDate.of(year, m, m).minusDays(m.toLong())
        println("${date.year} ${date.monthValue} ${date.dayOfMonth}")
    }
}