package baekjoon.silver.s1.`작업`

import java.util.StringTokenizer

var n = 0
var m = 0
var ans = 0

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: Array<Boolean>

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    graph = Array(n + 1) { ArrayList<Int>() }
    repeat(m) {
        val st = StringTokenizer(readLine())
        val (a, b) = Array(2) { st.nextToken().toInt() }
        graph[b].add(a)
    }

    visited = Array(n + 1) { false }

    val x = readLine().toInt()
    visited[x] = true
    dfs(x)
    println(ans)
}

fun dfs(cur: Int) {
    graph[cur].forEach {
        if (visited[it]) return@forEach
        ans++
        visited[it] = true
        dfs(it)
    }
}