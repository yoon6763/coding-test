package baekjoon.silver.s2.`알고리즘 수업 - 깊이 우선 탐색 2`

import java.util.StringTokenizer

lateinit var connected: Array<ArrayList<Int>>
lateinit var visited: Array<Int>
val sb = StringBuilder()
var cnt = 1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }

    connected = Array(n + 1) { ArrayList() }
    visited = Array(n + 1) { 0 }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (v1, v2) = Array(2) { st.nextToken().toInt() }
        connected[v1].add(v2)
        connected[v2].add(v1)
    }

    connected.forEach { it.sortDescending() }

    dfs(r)

    for (i in 1..n) {
        sb.append(visited[i]).append("\n")
    }

    print(sb)
}

fun dfs(idx: Int) {
    if (visited[idx] != 0) return

    visited[idx] = cnt++

    connected[idx].forEach { next ->
        dfs(next)
    }
}