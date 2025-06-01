package baekjoon.gold.g4.HeavyCargo

data class Edge(val v1: String, val v2: String, val cost: Int)

lateinit var parents: HashMap<String, String>

fun main() {
    var idx = 1
    while (true) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break

        parents = HashMap()

        val edges = mutableListOf<Edge>()

        repeat(m) {
            val (a, b, c) = readln().split(" ")
            edges += Edge(a, b, c.toInt())
        }

        val (start, end) = readln().split(" ")

        edges.sortBy { -it.cost }

        edges.forEach { edge ->
            parents[edge.v1] = edge.v1
            parents[edge.v2] = edge.v2
        }

        var ans = 987654321

        for (edge in edges) {
            if (union(edge.v1, edge.v2)) ans = minOf(ans, edge.cost)
            if (find(start) == find(end)) break
        }

        println("Scenario #${idx++}\n$ans tons\n")
    }
}

fun find(x: String): String {
    if (parents[x] != x) {
        parents[x] = find(parents[x]!!)
    }
    return parents[x]!!
}

fun union(x: String, y: String): Boolean {
    val (px, py) = find(x) to find(y)
    if (px == py) return false
    parents[px] = py
    return true
}