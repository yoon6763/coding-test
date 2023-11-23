package baekjoon.gold.g2.물대기

import java.util.PriorityQueue

data class Edge(val from: Int, val to: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return this.cost - other.cost
    }
}

lateinit var parent: Array<Int>

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val digCost = Array(n) { readLine().toInt() }
    val connectWeight = Array(n) { readLine().split(" ").map { it.toInt() } }
    parent = Array(n + 1) { it }

    val pq = PriorityQueue<Edge>()

    for (i in 0 until n)
        for (j in 0 until n)
            if (i != 0) pq.offer(Edge(i, j, connectWeight[i][j]))


    // 가상의 n번째 노드
    for (i in 0 until n) pq.offer(Edge(i, n, digCost[i]))

    var totalCost = 0L

    while (pq.isNotEmpty()) {
        val target = pq.poll()
        if (union(target.to, target.from)) totalCost += target.cost
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
    return if (nx != ny) {
        parent[nx] = ny
        true
    } else {
        false
    }
}