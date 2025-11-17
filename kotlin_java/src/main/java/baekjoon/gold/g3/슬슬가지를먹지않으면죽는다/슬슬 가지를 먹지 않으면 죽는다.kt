package baekjoon.gold.g3.슬슬가지를먹지않으면죽는다

data class Edge(val v1: Int, val v2: Int, val cost: Int)

lateinit var parent: IntArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val edges = mutableListOf<Edge>()
    parent = IntArray(n + 1) { -1 }

    repeat(m) {
        val (u, v, t) = readln().split(" ").map { it.toInt() }
        edges.add(Edge(u, v, t))
    }

    edges.sortBy { it.cost }

    var day = 1
    for ((v1, v2, cost) in edges) {
        if (cost != day) break
        if (!union(v1, v2)) break
        day++
    }

    println(day)
}

fun find(x: Int): Int {
    if (parent[x] < 0) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int): Boolean {
    var (px, py) = find(x) to find(y)
    if (px == py) return false
    if (parent[px] < parent[py]) {
        val temp = px
        px = py
        py = temp
    }
    parent[py] += parent[px]
    parent[px] = py
    return true
}