package baekjoon.bronze.b4

import java.time.LocalDate

fun main() {
    val (a, b) = List(2) { readln().toInt() }
    var date = LocalDate.of(2022, 11, a)
    date = date.plusWeeks(b.toLong())
    println(if (date.monthValue == 11) 1 else 0)
}