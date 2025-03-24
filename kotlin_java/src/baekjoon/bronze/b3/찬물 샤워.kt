package baekjoon.bronze.b3

import kotlin.math.abs

fun main() {
    val (n, k, t) = readln().split(" ").map { it.toInt() }
    val d = "0 ${readln()}".split(" ").map { it.toInt() }
    val list = MutableList(n + 1) { 0 }.apply { this[0] = t }
    list[0] = t

    (0..<n).forEach { i ->
        list[i + 1] = list[i] + d[i + 1] + if (list[i] != k) abs(list[i] - k) * (if (list[i] > k) -1 else 1) else 0
    }

    println(list.drop(1).sumOf { abs(it - k) })
}
