package baekjoon.bronze.b2

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() =
    println(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.of(2014, 4, 2).plusDays(readln().toLong() - 1)))