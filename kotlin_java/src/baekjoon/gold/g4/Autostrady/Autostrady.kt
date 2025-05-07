package baekjoon.gold.g4.Autostrady

data class Edge(val v1: Int, val v2: Int, val cost: Int)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val parent = IntArray(n + 1) { it }

    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val (px, py) = find(x) to find(y)
        if (px != py) parent[py] = px
        return px != py
    }

    print(MutableList(m) {
        val (v1, v2, cost) = readln().split(" ").map { it.toInt() }
        Edge(v1, v2, cost)
    }.sortedBy { it.cost }.fold(0) { acc, edge ->
        if (union(edge.v1, edge.v2)) maxOf(acc, edge.cost) else acc
    })
}