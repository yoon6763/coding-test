package baekjoon.bronze.b2

import kotlin.math.abs

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val (n, m, k) = input
    val goal = listOf(1, m + 1)
    val record = mutableListOf<Int>()

    repeat(k) {
        val classLocation = readln().split(" ").map { it.toInt() }
        record.add(abs(goal[0] - classLocation[0]) + abs(goal[1] - classLocation[1]))
    }

    println(record.indexOf(record.minOrNull()) + 1)
}
