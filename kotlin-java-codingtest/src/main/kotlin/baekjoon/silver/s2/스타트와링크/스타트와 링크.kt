package baekjoon.silver.s2.스타트와링크

import kotlin.math.abs
import kotlin.system.exitProcess

var n = 0
lateinit var map: Array<Array<Int>>
lateinit var visited: Array<Boolean>
var min = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    map = Array(n) { readLine().split(" ").map { it.toInt() }.toTypedArray() }
    visited = Array(n) { false }

    backTracking(0, 0)
    println(min)
}

fun backTracking(idx: Int, depth: Int) {
    if (depth == n / 2) {
        calc()
        return
    }

    for (i in idx until n) {
        if (!visited[i]) {
            visited[i] = true
            backTracking(i + 1, depth + 1)
            visited[i] = false
        }
    }
}

fun calc() {
    var sum = 0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (visited[i] && visited[j]) sum += map[i][j] + map[j][i]
            else if (!visited[i] && !visited[j]) sum -= map[i][j] + map[j][i]
        }
    }
    min = min.coerceAtMost(abs(sum))
    if (min == 0) {
        println(0)
        exitProcess(0)
    }
}