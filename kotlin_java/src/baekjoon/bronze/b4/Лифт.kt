package baekjoon.bronze.b4

import kotlin.math.abs

fun main() {
    val (n, k, a, b) = readln().split(" ").map { it.toInt() }
    println("${abs(1 - k) * b + (n - 1) * b} ${(n - 1) * a}")
}