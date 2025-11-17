package baekjoon.gold.g4.Explorace

data class Node(val v1: Int, val v2: Int, val cost: Int)

lateinit var parents: IntArray

fun main() = repeat(readln().toInt()) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    parents = IntArray(n + 1) { it }
    val edges = mutableListOf<Node>()
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        edges += Node(a, b, c)
    }

    edges.sortBy { it.cost }

    var ans = 0

    edges.forEach { edge ->
        if (union(edge.v1, edge.v2)) ans += edge.cost
    }

    println("Case #${it + 1}: $ans meters")
}

fun find(x: Int): Int {
    if (parents[x] != x) {
        parents[x] = find(parents[x])
    }

    return parents[x]
}

fun union(x: Int, y: Int): Boolean {
    val (px, py) = find(x) to find(y)
    if (px == py) return false
    parents[px] = py
    return true
}