package baekjoon.gold.g3.`안정적인 네트워크`

import java.util.StringTokenizer

data class Edge(val from: Int, val to: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return cost - other.cost
    }
}

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    parent = IntArray(n) { it }
    repeat(m) {
        val (u, v) = readLine().split(" ").map { it.toInt() - 1 }
        union(u, v)
    }

    val graph = List(n) {
        val st = StringTokenizer(readLine())
        List(n) { st.nextToken().toInt() }
    }

    val pq = ArrayList<Edge>()
    for (i in 1..<n) {
        for (j in i + 1..<n) {
            if (i == j) continue
            pq.add(Edge(i, j, graph[i][j]))
        }
    }

    pq.sort()

    var weightSum = 0
    var connectCount = 0
    val sb = StringBuilder()

    for (i in 0..<pq.size) {
        val cur = pq[i]

        if (union(cur.from, cur.to)) {
            weightSum += cur.cost
            connectCount++
            sb.append("${cur.from + 1} ${cur.to + 1}\n")
        }
    }

    println("$weightSum $connectCount")
    print(sb)
}

fun find(x: Int): Int {
    if (x == parent[x]) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int): Boolean {
    val (px, py) = find(x) to find(y)
    if (px == py) return false
    parent[px] = py
    return true
}