package baekjoon.gold.g4.`Out of Hay`

data class Edge(val v1: Int, val v2: Int, val cost: Int)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val edges = MutableList(m) {
        val (v1, v2, cost) = readln().split(" ").map { it.toInt() }
        Edge(v1, v2, cost)
    }.sortedBy { it.cost }

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

    println(edges.fold(0) { acc, edge -> if (union(edge.v1, edge.v2)) maxOf(acc, edge.cost) else acc })
}
