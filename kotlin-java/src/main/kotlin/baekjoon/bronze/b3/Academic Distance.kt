package baekjoon.bronze.b3

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    var ans = 0
    var cur = readln().split(" ").map { it.toInt() }

    repeat(n - 1) {
        val next = readln().split(" ").map { it.toInt() }
        ans += (abs(cur[0] - next[0]) + abs(cur[1] - next[1]))
        cur = next
    }

    println(ans)
}