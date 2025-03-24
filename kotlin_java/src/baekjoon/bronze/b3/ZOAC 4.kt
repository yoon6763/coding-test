package baekjoon.bronze.b3

import kotlin.math.ceil

fun main() {
    val (h, w, n, m) = readln().split(' ').map { it.toInt() }
    println(ceil(h / (n + 1.0)).toInt() * ceil(w / (m + 1.0)).toInt())
}
