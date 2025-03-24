package baekjoon.bronze.b4

import kotlin.math.sqrt

fun main() {
    val (w, h) = readln().split(" ").map { it.toDouble() }
    val sq = w + h
    val dia = sqrt(w * w + h * h)
    println("%.9f".format(sq - dia))
}
