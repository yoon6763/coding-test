package baekjoon.gold.g3.고속철도설계하기

import java.util.StringTokenizer

data class Node(val v1: Int, val v2: Int, val cost: Int)

lateinit var parent: IntArray

fun main() {
    val n = readln().toInt()

    parent = IntArray(n + 1) { it }
    val edges = mutableListOf<Node>()
    var totalCost = 0

    val arr = Array(n) {
        val st = StringTokenizer(readln())
        IntArray(n) { st.nextToken().toInt() }
    }

    for (i in 0 ..< n) {
        for (j in i + 1 ..< n) {
            if (arr[i][j] < 0) {
                totalCost -= arr[i][j]
                union(i + 1, j + 1)
            } else {
                edges.add(Node(i + 1, j + 1, arr[i][j]))
            }
        }
    }


    val connected = mutableListOf<Pair<Int, Int>>()
    var count = 0

    edges.sortedBy { it.cost }.forEach { edge ->
        if (!union(edge.v1, edge.v2)) return@forEach
        count++
        totalCost += edge.cost
        connected.add(edge.v1 to edge.v2)
    }

    println("$totalCost $count\n${connected.joinToString("\n") { "${it.first} ${it.second}" }}")
}

fun find(x: Int): Int {
    if (parent[x] != x) parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int): Boolean {
    val (px, py) = find(x) to find(y)
    if (px == py) return false
    parent[py] = px
    return true
}