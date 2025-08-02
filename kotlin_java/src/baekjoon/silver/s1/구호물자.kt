package baekjoon.silver.s1

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val graph = Array(n + 1) { ArrayList<Int>() }

    for (i in 1..<n) {
        readln()
        StringTokenizer(readln()).run { while (hasMoreTokens()) graph[i].add(nextToken().toInt()) }
    }

    val visited = IntArray(n + 1)

    fun dfs(start: Int): Boolean {
        visited[start] = -1
        graph[start].forEach { next -> if (visited[next] == -1 || visited[next] == 0 && dfs(next)) return true }
        visited[start] = 1
        return false
    }

    println(if (dfs(1)) "CYCLE" else "NO CYCLE")
}