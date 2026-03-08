package baekjoon.bronze.b3

import kotlin.math.abs
import kotlin.math.min

fun main() {
    val (p, m, c) = readln().split(" ").map { it.toInt() }
    val x = readln().toLong()

    var ans = Long.MAX_VALUE

    for (p in 1..p) {
        for (m in 1..m) {
            for (c in 1..c) {
                ans = min(ans, abs((p + m).toLong() * (m + c) - x))
            }
        }
    }

    println(ans)
}