package baekjoon.silver.s5

import java.time.LocalDate

fun main() {
    val start = readln().split(" ").map { it.toInt() }
    val end = readln().split(" ").map { it.toInt() }

    val startDate = LocalDate.of(start[0], start[1], start[2])
    val endDate = LocalDate.of(end[0], end[1], end[2])

    if (start[0] + 1000 < end[0] ||
        (start[0] + 1000 == end[0] && start[1] < end[1] ) ||
        (start[0] + 1000 == end[0] && start[1] == end[1] && start[2] <= end[2])) println("gg")
    else println("D-${endDate.toEpochDay() - startDate.toEpochDay()}")
}