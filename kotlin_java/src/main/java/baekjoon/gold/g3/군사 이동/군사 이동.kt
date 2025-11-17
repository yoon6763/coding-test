package baekjoon.gold.g3.`군사 이동`

import java.util.PriorityQueue
import java.util.StringTokenizer

data class Edge(val from: Int, val to: Int, val weight: Int)

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (p, w) = readLine().split(" ").map { it.toInt() }
    val (capital1, capital2) = readLine().split(" ").map { it.toInt() }

    val pq = PriorityQueue<Edge> { a, b -> b.weight - a.weight }
    repeat(w) {
        val st = StringTokenizer(readLine())
        pq.offer(Edge(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()))
    }

    parent = IntArray(p + 1) { it }

    while (pq.isNotEmpty()) {
        val (from, to, weight) = pq.poll()
        if (union(from, to)) {
            if (find(capital1) == find(capital2)) {
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
    if (px != py) {
        parent[py] = px
        return true
    }
    return false
}