package baekjoon.bronze.b3

import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    println((2.0.pow(n.toDouble()) + 1).pow(2.0).toInt())
}
