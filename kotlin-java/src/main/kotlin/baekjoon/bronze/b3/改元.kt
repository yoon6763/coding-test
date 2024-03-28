package baekjoon.bronze.b3

import java.time.LocalDate

fun main() {
    var standard = LocalDate.of(31, 4, 30)
    standard = standard.plusDays(1)

    while (true) {
        val line = readln()
        if (line == "#") break
        val (y, m, d) = line.split(" ").slice(1..3).map { it.toInt() }
        val date = LocalDate.of(y, m, d)
        if (date.isBefore(standard)) {
            println("HEISEI ${date.year} ${date.monthValue} ${date.dayOfMonth}")
        } else {
            println("? ${date.year - 30} ${date.monthValue} ${date.dayOfMonth}")
        }
    }
}