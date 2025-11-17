package baekjoon.gold.g4.가희와여행가요

data class Edge(val v1: Int, val v2: Int, val cost: Long, val time: Long)

lateinit var parent: IntArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    parent = IntArray(n + 1) { it }

    val (totalCost, maxTime) = List(m) {
        val (u, v, cost, time) = readln().split(" ").map { it.toLong() }
        Edge(u.toInt(), v.toInt(), cost, time)
    }.sortedWith(compareBy({ it.cost }, { it.time }))
        .fold(0L to 0L) { (costAcc, timeAcc), edge -> if (union(edge.v1, edge.v2)) costAcc + edge.cost to maxOf(timeAcc, edge.time) else costAcc to timeAcc }

    println(if (parent.mapIndexed { index, _ -> find(index) }.drop(1).all { it == parent[1] }) "$maxTime $totalCost" else -1)
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