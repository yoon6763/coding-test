package baekjoon.gold.g4.`떡장수와 호랑이`

import java.util.StringTokenizer

lateinit var graph: Array<IntArray>
lateinit var visited: Array<BooleanArray>
val sb = StringBuilder()
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    graph = Array(n) {
        val st = StringTokenizer(readLine())
        IntArray(st.nextToken().toInt()) { st.nextToken().toInt() }
    }

    visited = Array(n) { BooleanArray(10) }

    if (dfs(-1, 0)) {
        print(sb.reverse())
    } else {
        println(-1)
    }
}

fun dfs(pre: Int, depth: Int): Boolean {
    if (depth == n) {
        return true
    }

    for (i in 0..<graph[depth].size) {
        if (visited[depth][i] || pre == graph[depth][i]) continue
        visited[depth][i] = true
        if (dfs(graph[depth][i], depth + 1)) {
            sb.append("${graph[depth][i]}\n")
            return true
        }
    }

    return false
}