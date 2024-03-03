package baekjoon.gold.g5.ABCDE

import kotlin.system.exitProcess

lateinit var graph: Array<MutableList<Int>>
lateinit var visited: BooleanArray
var n = 0
var flag = false

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    val m = nm[1]
    graph = Array(n) { mutableListOf() }
    visited = BooleanArray(n)

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    for (i in 0..<n) {
        visited.fill(false)
        dfs(i, 0)
        if (flag) {
            println(1)
            return
        }
    }

    println(0)
}

fun dfs(cur: Int, depth: Int) {
    if (depth == 4) {
        flag = true
        return
    }

    visited[cur] = true
    graph[cur].forEach {
        if (visited[it]) return@forEach
        visited[it] = true
        dfs(it, depth + 1)
        visited[it] = false
    }
}