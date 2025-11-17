package baekjoon.silver.s1.트리를간단하게색칠하는최소비용

fun main() {
    val n = readln().toInt()
    val graph = Array(n) { mutableListOf<Int>() }

    repeat(n - 1) {
        val (v1, v2) = readln().split(" ").map { it.toInt() }
        graph[v1].add(v2)
        graph[v2].add(v1)
    }

    val cost = Array(n) { readln().split(" ").map { it.toLong() } }

    fun dfs(visited: BooleanArray, node: Int, color: Int): Long {
        visited[node] = true
        return cost[node][color] + graph[node]
            .filter { !visited[it] }
            .sumOf { dfs(visited, it, 1 - color) }
    }

    println(minOf(dfs(BooleanArray(n), 0, 0), dfs(BooleanArray(n), 0, 1)))
}