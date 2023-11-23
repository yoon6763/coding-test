package baekjoon.silver.s2.알고리즘수업_깊이우선탐색4

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

lateinit var connect: Array<ArrayList<Int>>
lateinit var visited: Array<Int>
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    val (m, start) = Array(2) { st.nextToken().toInt() }

    connect = Array(n + 1) { ArrayList<Int>() }
    visited = Array(n + 1) { -1 }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (v1, v2) = Array(2) { st.nextToken().toInt() }
        connect[v1].add(v2)
        connect[v2].add(v1)
    }
    connect.forEach { it.sortDescending() }

    visited[start] = 0
    dfs(start)
    val sb = StringBuilder()
    for (i in 1..n) sb.append(visited[i]).append("\n")
    print(sb)
}

fun dfs(node: Int) {
    connect[node].forEach { next ->
        if (visited[next] == -1) {
            visited[next] = visited[node] + 1
            dfs(next)
        }
    }
}