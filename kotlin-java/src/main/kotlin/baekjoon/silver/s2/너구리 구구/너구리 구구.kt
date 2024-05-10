package baekjoon.silver.s2.`너구리 구구`

import java.util.*

data class Edge(val to: Int, val cost: Int)

lateinit var connect: Array<ArrayList<Edge>>
lateinit var visited: BooleanArray
var n = 0
var ans = 0L

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    connect = Array(n + 1) { arrayListOf() }
    repeat(n - 1) {
        val st = StringTokenizer(readLine())
        val (u, v, cost) = List(3) { st.nextToken().toInt() }
        connect[u].add(Edge(v, cost))
        connect[v].add(Edge(u, cost))
    }

    visited = BooleanArray(n + 1)
    dfs(1, 0L)
    println(ans)
}

fun dfs(cur: Int, sum: Long) {
    ans = maxOf(ans, sum)
    visited[cur] = true

    for (i in 0..<connect[cur].size) {
        val (next, cost) = connect[cur][i]
        if (visited[next]) continue
        dfs(next, sum + cost)
    }
}