package baekjoon.silver.s2

fun main() {
    val n = readln().toInt()
    val graph = Array(n) { mutableListOf<Int>() }

    repeat(n - 1) {
        val (cn, d1, d2) = readln().split(" ").map { it.toInt() }
        graph[cn] += if (d1 != 0) d1 else -1
        graph[cn] += if (d2 != 0) d2 else -1
    }

    var maxDepth = 0

    fun dfs(cur: Int, depth: Int) {
        if (cur == -1) {
            maxDepth = maxOf(maxDepth, depth)
            return
        }
        graph[cur].forEach { next -> dfs(next, depth + 1) }
    }
    dfs(1, 0)
    println(maxDepth)
}
