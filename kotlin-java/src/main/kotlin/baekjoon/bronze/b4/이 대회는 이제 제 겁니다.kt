package baekjoon.bronze.b4

import kotlin.math.max

fun main() {
    val (a, p, c) = readln().split(" ").map { it.toInt() }
    println(max(a + c, p))
}