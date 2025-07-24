package baekjoon.silver.s2

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val friends = Array(m) { readln().toInt() - 1 }
    val graph = Array(n) { mutableListOf<Int>() }
    repeat(k) {
        val (a, b) = readln().split(" ").map { it.toInt() - 1 }
        graph[a] += b
        graph[b] += a
    }

    val visited = BooleanArray(n)

    fun dfs(cur: Int) {
        visited[cur] = true
        graph[cur].forEach { next ->
            if (visited[next]) return@forEach
            dfs(next)
        }
    }

    friends.forEach { dfs(it) }
    println(visited.count { it })
}