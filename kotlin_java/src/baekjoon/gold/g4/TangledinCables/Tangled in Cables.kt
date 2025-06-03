package baekjoon.gold.g4.TangledinCables

data class Edge(val v1: String, val v2: String, val cost: Double)

lateinit var parent: Map<String, String>

fun main() {
    val cableLength = readln().toDouble()
    parent = List(readln().toInt()) { readln() }.associateWith { it }

    var ans = 0.0

    List(readln().toInt()) {
        val (v1, v2, cost) = readln().split(" ")
        Edge(v1, v2, cost.toDouble())
    }.sortedBy { it.cost }.forEach { edge ->
        if (union(edge.v1, edge.v2)) ans += edge.cost
    }

    println(if (ans > cableLength) "Not enough cable" else "Need ${"%.1f".format(ans)} miles of cable")
}

fun find(x: String): String {
    if (parent[x] != x) {
        parent = parent + (x to find(parent[x]!!))
    }
    return parent[x]!!
}

fun union(x: String, y: String): Boolean {
    val (px, py) = find(x) to find(y)
    if (px != py) {
        parent = parent + (py to px)
    }
    return px != py
}