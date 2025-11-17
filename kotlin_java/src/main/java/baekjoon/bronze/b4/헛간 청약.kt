package baekjoon.bronze.b4

import kotlin.math.min

fun main() {
    val (n, w, h, l) = readln().split(" ").map { it.toInt() }
    val ans = (w / l) * (h / l)
    println(min(n.toDouble(), ans.toDouble()).toInt())
}
