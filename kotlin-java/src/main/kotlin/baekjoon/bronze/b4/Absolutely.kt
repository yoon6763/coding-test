package baekjoon.bronze.b4

import kotlin.math.abs

fun main() {
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toDouble() }
        println("%.1f".format(abs(a - b)))
    }
}