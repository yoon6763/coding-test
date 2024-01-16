package baekjoon.gold.g3.`중량제한_분리집합`

import java.util.PriorityQueue

data class Edge(val from: Int, val to: Int, val weight: Int)

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    parent = IntArray(n + 1) { it }

    val pq = PriorityQueue<Edge>(compareBy { -it.weight })

    repeat(m) {
        val (from, to, weight) = readLine().split(" ").map { it.toInt() }
        pq.offer(Edge(from, to, weight))
    }

    val (start, end) = readLine().split(" ").map { it.toInt() }

    while (pq.isNotEmpty()) {
        val (from, to, weight) = pq.poll()
        if (union(from, to)) {
            if (find(start) == find(end)) {
                println(weight)
                return
            }
        }
    }
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