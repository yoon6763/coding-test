package baekjoon.bronze.b1

import kotlin.math.abs

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val pairs = mutableListOf<Pair<Int, Int>>()
    for (i in 0..<n) {
        for (j in 0..<m) {
            if (arr[i][j] == 1) {
                pairs.add(Pair(i, j))
            }
        }
    }

    println(abs(pairs[0].first - pairs[1].first) + abs(pairs[0].second - pairs[1].second))
}