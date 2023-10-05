package baekjoon.platinum.p4.유럽여행

import java.util.PriorityQueue

data class Edge(val from: Int, val to: Int, val weight: Int)

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map(String::toInt)
    val visitedFee = Array(n + 1) { if (it == 0) 0 else readLine().toInt() }
    parent = IntArray(n + 1) { it }

    val pq = PriorityQueue<Edge>(compareBy { it.weight })

    repeat(m) {
        val (from, to, weight) = readLine().split(" ").map(String::toInt)
        pq.offer(Edge(from, to, weight * 2 + visitedFee[from] + visitedFee[to]))
    }

    var ans = 0
    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (union(cur.from, cur.to)) ans += cur.weight
    }

    println(ans + visitedFee.slice(1..n).minOrNull()!!)
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int): Boolean {
    val (px, py) = find(x) to find(y)
    return if (px == py) false
    else {
        parent[px] = py
        true
    }
}