package baekjoon.silver.s2.ClearColdWater

fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(c) {
        val (p, c1, c2) = readln().split(" ").map { it.toInt() }
        graph[p].add(c1)
        graph[p].add(c2)
    }

    val distance = IntArray(n + 1)

    fun dfs(cur: Int, depth: Int) {
        distance[cur] = depth
        graph[cur].forEach { next ->
            if (distance[next] != 0) return@forEach
            dfs(next, depth + 1)
        }
    }

    dfs(1, 1)
    println(distance.drop(1).joinToString("\n"))
}
