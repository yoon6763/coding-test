package baekjoon.platinum.p5.경찰차

import kotlin.math.abs

val sb = StringBuilder()
var n = 0
var m = 0
lateinit var incidents: Array<Pair<Int, Int>>
lateinit var dp: Array<Array<Int>>

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    m = readLine().toInt()
    incidents = Array(m + 1) { Pair(0, 0) }
    dp = Array(m + 1) { Array(m + 1) { 0 } }

    for (i in 1..m) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        incidents[i] = Pair(x, y)
    }

    sb.appendLine(solve(0, 0))
    route(0, 0)

    print(sb)
}


fun solve(first: Int, second: Int): Int {
    if (first == m || second == m) return 0
    if (dp[first][second] != 0) return dp[first][second]

    val next = maxOf(first, second) + 1

    val firstDistance =
        if (first == 0) getManhattanDistance(Pair(1, 1), incidents[next])
        else getManhattanDistance(incidents[first], incidents[next])

    val secondDistance =
        if (second == 0) getManhattanDistance(Pair(n, n), incidents[next])
        else getManhattanDistance(incidents[second], incidents[next])


    dp[first][second] = minOf(
        solve(next, second) + firstDistance,
        solve(first, next) + secondDistance
    )

    return dp[first][second]
}


fun route(first: Int, second: Int) {
    if (first == m || second == m) return

    val next = maxOf(first, second) + 1

    val firstDistance =
        if (first == 0) getManhattanDistance(Pair(1, 1), incidents[next])
        else getManhattanDistance(incidents[first], incidents[next])

    if (dp[first][second] == solve(next, second) + firstDistance) {
        sb.appendLine(1)
        route(next, second)
    } else {
        sb.appendLine(2)
        route(first, next)
    }
}

fun getManhattanDistance(p1: Pair<Int, Int>, p2: Pair<Int, Int>) = abs(p1.first - p2.first) + abs(p1.second - p2.second)
