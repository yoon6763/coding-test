package baekjoon.silver.s2.`영일랜드`

import java.util.*

data class Edge(val to: Int, val weight: Int)

lateinit var graph: Array<IntArray>
lateinit var visited: BooleanArray
var n = 0
var ans = -1

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    graph = Array(n + 1) { IntArray(n + 1) }
    visited = BooleanArray(n + 1)

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val (from, to, cost) = List(3) { st.nextToken().toInt() }
        if (from == to) return@repeat
        graph[from][to] = maxOf(graph[from][to], cost)
    }

    dfs(0, 0, 0)
    println(ans)
}

fun dfs(cur: Int, depth: Int, sum: Int) {
    if (depth == n) {
        if (graph[cur][0] != 0) ans = maxOf(ans, sum + graph[cur][0])
        return
    }

    for (next in 1..n) {
        if (visited[next] || graph[cur][next] == 0) continue
        visited[next] = true
        dfs(next, depth + 1, sum + graph[cur][next])
        visited[next] = false
    }
}