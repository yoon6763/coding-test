package baekjoon.silver.s1

fun main() = repeat(readln().toInt()) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a] += b
    }

    fun dfs(cur: Int, visited: BooleanArray): BooleanArray {
        graph[cur].forEach { next ->
            if (visited[next]) return@forEach
            visited[next] = true
            dfs(next, visited)
        }
        return visited
    }

    println((1..n).sumOf { idx -> dfs(idx, BooleanArray(n + 1).also { it[idx] = true }).count { it } - 1 })
}