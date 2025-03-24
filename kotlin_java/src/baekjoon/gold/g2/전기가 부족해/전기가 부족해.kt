package baekjoon.gold.g2.`전기가 부족해`

import java.util.StringTokenizer

data class Edge(val from: Int, val to: Int, val cost: Int)

lateinit var parent: Array<Int>
lateinit var powerPlant: List<Int>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }

    parent = Array(n + 1) { it }

    val edges = ArrayList<Edge>()
    powerPlant = readLine().split(" ").map { it.toInt() }

    repeat(m) {
        val st = StringTokenizer(readLine())
        edges.add(Edge(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()))
    }
    edges.sortBy { it.cost }


    var totalCost = 0

    edges.forEach { edge ->
        if (union(edge.to, edge.from)) totalCost += edge.cost
    }
    println(totalCost)
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int): Boolean {
    val nx = find(x)
    val ny = find(y)

    if (nx in powerPlant && ny in powerPlant) return false

    if (nx != ny) {
        if (nx in powerPlant) parent[ny] = nx
        else parent[nx] = ny
        return true
    }

    return false
}