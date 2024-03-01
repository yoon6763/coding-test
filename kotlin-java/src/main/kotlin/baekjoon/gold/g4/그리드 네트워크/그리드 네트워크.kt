package baekjoon.gold.g4.`그리드 네트워크`

import java.util.PriorityQueue
import java.util.StringTokenizer

data class Edge(val u: Int, val v: Int, val w: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return w - other.w
    }
}

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val pq = PriorityQueue<Edge>()
        val (n, m) = readLine().split(" ").map { it.toInt() }
        parent = IntArray(n * m) { it }
        for (i in 0..<n) {
            val st = StringTokenizer(readLine())
            for (j in 0..<m - 1) {
                val start = i * m + j
                val end = start + 1
                pq.offer(Edge(start, end, st.nextToken().toInt()))
            }
        }
        for (i in 0..<n - 1) {
            val st = StringTokenizer(readLine())
            for (j in 0..<m) {
                val start = i * m + j
                val end = start + m
                pq.offer(Edge(start, end, st.nextToken().toInt()))
            }
        }

        var total = 0
        while (pq.isNotEmpty()) {
            val (u, v, w) = pq.poll()
            if (union(u, v)) total += w
        }
        sb.appendLine(total)
    }
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