package baekjoon.gold.g3.`등수 찾기`

import java.util.StringTokenizer

lateinit var upGraph: Array<MutableList<Int>>
lateinit var downGraph: Array<MutableList<Int>>
lateinit var visited: BooleanArray
var size = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, x) = readLine().split(" ").map { it.toInt() }

    upGraph = Array(n + 1) { mutableListOf() }
    downGraph = Array(n + 1) { mutableListOf() }
    visited = BooleanArray(n + 1)

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (up, down) = st.nextToken().toInt() to st.nextToken().toInt()
        upGraph[down].add(up)
        downGraph[up].add(down)
    }

    dfs(x, 0, upGraph)
    val upDepth = size
    size = 0
    dfs(x, 0, downGraph)
    val downDepth = size

    println("${upDepth + 1} ${n - downDepth}")
}

fun dfs(cur: Int, depth: Int, graph: Array<MutableList<Int>>) {
    visited[cur] = true
    graph[cur].forEach { next ->
        if (visited[next]) return@forEach
        size++
        visited[next] = true
        dfs(next, depth + 1, graph)
    }
}