package baekjoon.silver.s1

fun main() {
    val (n, m, _) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 2) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a] += b
        graph[b] += a
    }

    val disable = readln().split(" ").map { it.toInt() }.toTypedArray()
    val visited = BooleanArray(n + 2)

    fun dfs(node: Int) {
        if (visited[node]) return
        visited[node] = true
        graph[node].forEach { next ->
            if (next in disable) return@forEach
            dfs(next)
        }
    }

    dfs(1)
    println(visited.count { it } - 1)
}