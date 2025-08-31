package baekjoon.silver.s1

fun main() {
    data class Edge(val to: Int, val weight: Int)

    repeat(readln().toInt()) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val graph = Array(n + 1) { mutableListOf<Edge>() }

        repeat(n - 1) {
            val (v1, v2, d) = readln().split(" ").map { it.toInt() }
            graph[v1].add(Edge(v2, d))
        }

        val distance = IntArray(n + 1)

        fun dfs(cur: Int, acc: Int) {
            if (distance[cur] != 0) return
            distance[cur] = acc
            graph[cur].forEach { (to, weight) -> dfs(to, acc + weight) }
        }

        dfs(1, 0)
        println(distance.max().let { if (it < m) -1 else it })
    }
}