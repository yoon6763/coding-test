package baekjoon.bronze.b2

import kotlin.math.abs

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val std = readln().split(" ").map { it.toLong() }

    var cnt = 0
    repeat(n - 1) {
        val arr = readln().split(" ").map { it.toLong() }
        var sum = 0L
        for (i in 0 until m) {
            sum += abs(std[i] - arr[i])
        }
        if (sum > 2000) cnt++
    }
    if (cnt.toDouble() >= (n - 1).toDouble() / 2) println("YES") else println("NO")
}