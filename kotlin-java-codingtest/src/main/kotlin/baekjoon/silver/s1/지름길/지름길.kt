package baekjoon.silver.s1.지름길

import kotlin.collections.ArrayList

data class Edge(val from: Int, val to: Int, val weight: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, d) = readLine().split(" ").map { it.toInt() }

    val edges = ArrayList<Edge>()

    repeat(n) {
        val (from, to, weight) = readLine().split(" ").map { it.toInt() }
        edges.add(Edge(from, to, weight))
    }

    val distances = IntArray(d + 1) { it }

    edges.sortedBy { it.from }.forEach { edge ->
        if (edge.from > d || edge.to > d) return@forEach

        var tempWeight = edge.weight + distances[edge.from]

        for (i in edge.to..d) {
            distances[i] = minOf(distances[i], tempWeight)
            tempWeight++
        }
    }

    println(distances[d])
}
