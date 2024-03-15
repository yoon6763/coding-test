package baekjoon.gold.g3.`MST 게임`

import java.util.StringTokenizer

data class Edge(val from: Int, val to: Int, val cost: Int)

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }

    val edges = Array(m) {
        val (from, to) = StringTokenizer(readLine()).let { st -> List(2) { st.nextToken().toInt() - 1 } }
        Edge(from, to, it + 1)
    }

    val answer = ArrayList<Int>()
    val notUsedEdges = BooleanArray(m)

    for (i in 0..<k) {
        parent = IntArray(n) { it }

        var sum = 0
        var count = 0
        var first = true

        for (j in 0..<m) {
            if (notUsedEdges[j]) continue
            val (from, to, cost) = edges[j]

            if (union(from, to)) {
                if (first) {
                    first = false
                    notUsedEdges[j] = true
                }
                sum += cost
                count++
            }

            if (count == n - 1) break
        }

        answer.add(if (count == n - 1) sum else 0)
    }

    println(answer.joinToString(" "))
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