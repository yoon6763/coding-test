package baekjoon.bronze.b2

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val (x, y, r) = readln().split(" ").map { it.toInt() }

    var inCircle = 0
    var round = 0

    repeat(n) {
        val d = abs(readln().toInt() - x)

        when {
            d < r -> inCircle++
            d == r -> round++
        }
    }

    println("$inCircle $round")
}