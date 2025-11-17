package baekjoon.bronze.b3

import kotlin.math.*

fun main() {
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toLong() }
        val s = ceil(cbrt(a.toDouble())).toLong()
        val e = floor(cbrt(b.toDouble())).toLong()
        println("Case #${it + 1}: ${if (e >= s) e - s + 1 else 0}")
    }
}