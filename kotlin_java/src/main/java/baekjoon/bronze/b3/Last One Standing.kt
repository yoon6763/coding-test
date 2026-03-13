package baekjoon.bronze.b3

import kotlin.math.ceil

fun main() {
    val (h1, d1, t1) = readln().split(" ").map { it.toLong() }
    val (h2, d2, t2) = readln().split(" ").map { it.toLong() }
    val k1 = (h2 + d1 - 1) / d1
    val k2 = (h1 + d2 - 1) / d2

    val time1 = (k1 - 1) * t1
    val time2 = (k2 - 1) * t2
    when {
        time1 < time2 -> println("player one")
        time1 > time2 -> println("player two")
        else -> println("draw")
    }
}