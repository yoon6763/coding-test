package baekjoon.bronze.b4

import kotlin.math.abs

fun main() {
    val (a, b, c, d, e) = List(5) { readln().toInt() }
    if (a < 0) println(abs(a) * c + d + b * e) else println((b - a) * e)
}
