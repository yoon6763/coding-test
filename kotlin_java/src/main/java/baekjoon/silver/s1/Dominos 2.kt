package baekjoon.silver.s1

fun main() = repeat(readln().toInt()) {
    val (n, m, l) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        graph[x].add(y)
    }

    val visited = BooleanArray(n + 1)
    var count = 0

    fun dfs(node: Int) {
        if (visited[node]) return
        visited[node] = true
        count++
        graph[node].forEach { dfs(it) }
    }

    List(l) { readln().toInt() }.forEach { dfs(it) }
    println(count)
}
