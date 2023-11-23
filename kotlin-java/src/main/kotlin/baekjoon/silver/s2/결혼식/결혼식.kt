package baekjoon.silver.s2.결혼식

var n = 0
lateinit var visited: Array<Boolean>
lateinit var connect: Array<ArrayList<Int>>
var cnt = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    connect = Array(n + 1) { ArrayList() }
    visited = Array(n + 1) { false }
    repeat(readLine().toInt()) {
        val (p1, p2) = readLine().split(" ").map { it.toInt() }
        connect[p1].add(p2)
        connect[p2].add(p1)
    }

    visited[1] = true
    dfs(1, 0)
    println(visited.count { it } - 1) // visited가 true인 것 카운팅 - 1
}

fun dfs(idx: Int, depth: Int) {
    if (depth == 2) return
    connect[idx].forEach {
        if (!visited[it]) visited[it] = true
        dfs(it, depth + 1)
    }
}