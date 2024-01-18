package baekjoon.bronze.b3

import kotlin.math.max

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val max = max((b - a).toDouble(), (c - b).toDouble()).toInt()
    println(max - 1)
}
