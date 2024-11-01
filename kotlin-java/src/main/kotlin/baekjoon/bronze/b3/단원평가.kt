package baekjoon.bronze.b3

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toDouble() }
    println((if (c == 0.0) sqrt(a + b) else c.pow(2) - a - b).toInt())
}