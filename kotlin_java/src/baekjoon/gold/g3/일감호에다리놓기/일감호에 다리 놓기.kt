package baekjoon.gold.g3.일감호에다리놓기

import java.util.*
import kotlin.collections.HashSet

data class Edge(val from: Int, val to: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge) = cost - other.cost
}

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val nmk = StringTokenizer(readLine())
    val n = nmk.nextToken().toInt()
    val m = nmk.nextToken().toInt()
    val k = nmk.nextToken().toLong()

    parent = IntArray(n + 1) { it }

    if (m <= 1) {
        println("YES")
        return
    }

    val cost = readLine().trim().split(" ").map { it.toInt() }

    val near = HashSet<Edge>()
    for (i in 1..<n) {
        near.add(Edge(i, i + 1, 0))
    }
    near.add(Edge(1, n, 0))

    repeat(m) {
        val (v1, v2) = StringTokenizer(readLine().trim()).let { st -> List(2) { st.nextToken().toInt() } }.sorted()
        near.remove(Edge(v1, v2, 0))
    }

    val pq = PriorityQueue<Edge>(near)

    for (i in 1..n) {
        pq.offer(Edge(0, i, cost[i - 1]))
    }

    var sum = 0L

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        if (union(cur.from, cur.to)) {
            sum += cur.cost
        }

        if (sum > k) {
            println("NO")
            return
        }
    }

    println("YES")
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