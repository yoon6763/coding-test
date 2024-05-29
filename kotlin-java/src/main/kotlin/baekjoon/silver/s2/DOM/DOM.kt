package baekjoon.silver.s2.DOM

import kotlin.system.exitProcess

var count = 0
val graph = IntArray(1000001)
val visited = BooleanArray(1000001)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, p) = readLine().split(" ").map { it.toInt() }

    repeat(n) {
        val (favourite, hate) = readLine().split(" ").map { it.toInt() }
        if (graph[hate] == 0) graph[hate] = favourite
    }

    solve(p)
    println(count)
}

fun solve(cur: Int) {
    if (visited[cur]) {
        println(-1)
        exitProcess(0)
    }
    if (graph[cur] != 0) {
        count++
        visited[cur] = true
        solve(graph[cur])
    }
}
