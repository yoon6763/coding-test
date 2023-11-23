package baekjoon.gold.g4.세부

data class Edge(val from: Int, val to: Int, val cost: Int)

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val (s, e) = readLine().split(" ").map { it.toInt() }
    parent = IntArray(n + 1) { it }

    val edges = ArrayList<Edge>()

    for (i in 0 until m) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() }
        edges.add(Edge(from, to, cost))
    }

    edges.sortByDescending { it.cost }

    for ((from, to, cost) in edges) {
        if (union(from, to) && find(s) == find(e)) {
            println(cost)
            return
        }
    }

    println(0)
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int): Boolean {
    val (nx, ny) = find(x) to find(y)
    return if (nx == ny) false
    else {
        parent[nx] = ny
        true
    }
}