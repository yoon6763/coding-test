package baekjoon.bronze.b2

import kotlin.math.max

fun main() {
    val (a, b, k) = readLine()!!.split(" ").map { it.toInt() }
    println((a / k) * (b / k) - max(0, a / k - 2) * max(0, b / k - 2))
}
