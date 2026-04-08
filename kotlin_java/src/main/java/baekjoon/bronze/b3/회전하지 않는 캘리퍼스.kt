package baekjoon.bronze.b3

import kotlin.math.max
import kotlin.math.min

fun main() {
    var mx = Int.MIN_VALUE
    var mn = Int.MAX_VALUE

    repeat(readln().toInt()) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        mx = max(mx, y)
        mn = min(mn, y)
    }

    println(mx - mn)
}