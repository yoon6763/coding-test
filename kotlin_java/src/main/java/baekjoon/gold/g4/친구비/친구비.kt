package baekjoon.gold.g4.친구비

import java.util.*
import kotlin.collections.HashSet

data class Cost(val index: Int, val cost: Int)

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer("0 ${readLine()}")
    val costs = Array(n + 1) { Cost(it, st.nextToken().toInt()) }.sortedBy { it.cost }

    parent = IntArray(n + 1) { it }

    for (i in 0..<m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        union(a, b)
    }

    val friendsRoot = HashSet(parent.map { find(it) })

    var ans = 0

    for (i in 1..n) {
        val root = find(costs[i].index)
        if (root in friendsRoot) {
            friendsRoot.remove(root)
            ans += costs[i].cost
        }

        if (friendsRoot.isEmpty()) break
    }

    println(if (ans <= k) ans else "Oh no")
}

fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int) {
    val (px, py) = find(x) to find(y)
    parent[py] = px
}