package baekjoon.silver.s3.병든나이트

import kotlin.math.min

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(
        when {
            n == 1 -> 1
            n == 2 -> min(4, (m + 1) / 2)
            m < 7 -> min(4, m)
            else -> m - 2
        }
    )
}