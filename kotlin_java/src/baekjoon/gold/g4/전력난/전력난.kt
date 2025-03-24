package baekjoon.gold.g4.전력난

import java.util.*

data class Edge(val from: Int, val to: Int, val cost: Long) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return (this.cost - other.cost).toInt()
    }
}

lateinit var parent: Array<Int>

fun main() {
    val sb = StringBuilder()
    val br = System.`in`.bufferedReader()
    var maxCost = 0L
    var total = 0L
    var pq = PriorityQueue<Edge>()

    while (true) {
        val mn = br.readLine().split(" ")
        val m = mn[0].toInt() // 집의 개수
        val n = mn[1].toInt() // 길의 개수

        if(n == 0 && m == 0) break

        parent = Array(m) { it }

        pq = PriorityQueue<Edge>()
        maxCost = 0L

        repeat(n) {
            val abw = br.readLine().split(" ") // 출발, 도착, 비용
            val a = abw[0].toInt()
            val b = abw[1].toInt()
            val w = abw[2].toLong()
            maxCost += w
            pq.add(Edge(a, b, w))
        }

        total = 0L
        while (pq.isNotEmpty()) {
            val edge = pq.poll()
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to)
                total += edge.cost
            }
        }

        sb.append(maxCost - total).append("\n")
    }
    print(sb)
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int) {
    val nx = find(x)
    val ny = find(y)
    if (nx != ny) {
        parent[nx] = ny
    }
}