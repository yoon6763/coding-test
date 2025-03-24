package baekjoon.bronze.b4

import kotlin.math.min

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    println((min(m.toDouble(), k.toDouble()) + min((n - m).toDouble(), (n - k).toDouble())).toInt())
}