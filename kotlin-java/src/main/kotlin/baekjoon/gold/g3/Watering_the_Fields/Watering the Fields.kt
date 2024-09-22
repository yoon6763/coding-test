package baekjoon.gold.g3.Watering_the_Fields

import java.util.*

data class Edge(val u: Int, val v: Int, val w: Long) : Comparable<Edge> {
    override fun compareTo(other: Edge) = this.w.compareTo(other.w)
}

data class Point(val x: Int, val y: Int)

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, minWeight) = readLine().split(" ").map { it.toInt() }
    parent = IntArray(n) { it }

    val points = Array(n) { readLine().split(" ").map { it.toLong() } }
    val pq = PriorityQueue<Edge>()

    for (i in 0..<n) {
        val (x1, y1) = points[i]
        for (j in i + 1..<n) {
            val (x2, y2) = points[j]
            pq.add(Edge(i, j, (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)))
        }
    }

    var total = 0L
    var cnt = 0

    while (pq.isNotEmpty()) {
        val (u, v, w) = pq.poll()
        if (w < minWeight || !union(u, v)) continue
        cnt++
        total += w
        if (cnt == n - 1) {
            println(total)
            return
        }
    }

    println(-1)
}

fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int): Boolean {
    val (px, py) = find(x) to find(y)
    if (px == py) return false
    parent[py] = px
    return true
}