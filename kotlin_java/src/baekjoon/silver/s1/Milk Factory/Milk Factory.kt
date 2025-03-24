package baekjoon.silver.s1.`Milk Factory`

lateinit var graph: Array<MutableList<Int>>
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    graph = Array(n + 1) { mutableListOf() }

    for (i in 0..<n - 1) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[b].add(a)
    }

    for (i in 1..n) {
        visited = BooleanArray(n + 1) { false }
        if (!visited[i]) {
            dfs(i)
        }
        if (visited.count { it } == n) {
            println(i)
            return
        }
    }

    println(-1)
}


fun dfs(cur: Int) {
    visited[cur] = true
    graph[cur].forEach { next ->
        if (!visited[next]) {
            dfs(next)
            visited[next] = true
        }
    }
}