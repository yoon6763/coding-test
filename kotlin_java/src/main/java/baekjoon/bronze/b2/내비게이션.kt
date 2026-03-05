package baekjoon.bronze.b2

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val (sx, sy, ex, ey) = readln().split(" ").map { it.toLong() }

    var minDist = Long.MAX_VALUE
    var answer = 0

    repeat(n) {
        val m = readln().toInt()

        var px = sx
        var py = sy
        var dist = 0L

        repeat(m) {
            val (x, y) = readln().split(" ").map { it.toLong() }
            dist += abs(px - x) + abs(py - y)
            px = x
            py = y
        }

        dist += abs(px - ex) + abs(py - ey)

        if (dist < minDist) {
            minDist = dist
            answer = it + 1
        }
    }

    println(answer)
}