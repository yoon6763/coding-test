package baekjoon.bronze.b3

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val (a, b) = List(2) { readln().split(" ").map { it.toInt() } }
    println((0..<n).sumOf { abs(a[it] - b[it]) } / 2)
}