package baekjoon.gold.g4.BadCowtractors

data class Edge(val v1: Int, val v2: Int, val cost: Int)

lateinit var parent: IntArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    parent = IntArray(n + 1) { it }

    val edges = ArrayList<Edge>()
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        edges.add(Edge(a, b, c))
    }

    edges.sortBy { -it.cost }

    var totalCost = 0
    var count = 0

    edges.forEach { edge ->
        if (!union(edge.v1, edge.v2)) return@forEach
        totalCost += edge.cost
        count++
    }

    println(if (count == n - 1) totalCost else -1)
}

fun find(x: Int): Int {
    if (parent[x] != x) {
        parent[x] = find(parent[x])
    }
    return parent[x]
}

fun union(x: Int, y: Int): Boolean {
    val (px, py) = find(x) to find(y)
    if (px != py) {
        parent[px] = py
        return true
    }

    return false
}