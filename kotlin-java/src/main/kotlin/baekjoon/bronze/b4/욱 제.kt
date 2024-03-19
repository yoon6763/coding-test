package baekjoon.bronze.b4

import kotlin.math.pow

fun main() {
    val (A, B) = readln().split(" ").map { it.toDouble() }
    val M = (B - A) / 400
    println(1 / (1 + 10.0.pow(M)))
}
