package baekjoon.gold.g3.ArcticNetwork

import kotlin.math.*

data class Edge(val v1: Int, val v2: Int, val dist: Double) : Comparable<Edge> {
    override fun compareTo(other: Edge) = dist.compareTo(other.dist)
}

lateinit var parent: IntArray

fun main() = repeat(readln().toInt()) {
    val (s, p) = readln().split(" ").map { it.toInt() }

    val points = Array(p) { readln().split(" ").map { it.toDouble() } }
    val edges = mutableListOf<Edge>()

    for (i in 0 until p) {
        for (j in i + 1 until p) {
            edges.add(Edge(i, j, hypot((points[i][0] - points[j][0]), (points[i][1] - points[j][1]))))
        }
    }

    parent = IntArray(p) { it }

    edges.sort()
    val mst = mutableListOf<Double>()

    edges.forEach { edge ->
        if (!union(edge.v1, edge.v2)) return@forEach
        mst.add(edge.dist)
    }

    println("%.2f".format(mst.sortedDescending()[s - 1]))
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