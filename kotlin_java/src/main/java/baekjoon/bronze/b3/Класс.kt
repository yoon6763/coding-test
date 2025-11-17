package baekjoon.bronze.b3

import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    println(min(n, m) * 2 + ((n + m) % 2))
}