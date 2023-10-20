package baekjoon.platinum.p5.정점들의_거리

import java.lang.StringBuilder

data class Edge(val v1: Int, val v2: Int)

lateinit var costTable: HashMap<Edge, Int>
lateinit var depths: IntArray
lateinit var parents: IntArray
lateinit var connected: Array<ArrayList<Int>>

var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    costTable = HashMap()
    connected = Array(n + 1) { ArrayList<Int>() }
    depths = IntArray(n + 1)
    parents = IntArray(n + 1) { -1 }

    repeat(n - 1) {
        val (v1, v2, cost) = readLine().split(" ").map(String::toInt)
        costTable[Edge(v1, v2)] = cost
        costTable[Edge(v2, v1)] = cost
        connected[v1].add(v2)
        connected[v2].add(v1)
    }

    dfs(1, 0, 1)

    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val (v1, v2) = readLine().split(" ").map(String::toInt)
        sb.appendLine(LCA(v1, v2))
    }

    print(sb)
}

fun LCA(v1: Int, v2: Int): Int {
    var sumDistance = 0

    var v1 = v1
    var v2 = v2

    var depth1 = depths[v1]
    var depth2 = depths[v2]

    while (depth1 > depth2) {
        sumDistance += costTable[(Edge(v1, parents[v1]))] ?: costTable[(Edge(parents[v1], v1))]!!
        v1 = parents[v1]
        depth1--
    }

    while (depth1 < depth2) {
        sumDistance += costTable[(Edge(v2, parents[v2]))] ?: costTable[(Edge(parents[v2], v2))]!!
        v2 = parents[v2]
        depth2--
    }

    while (v1 != v2) {
        sumDistance += costTable[(Edge(v1, parents[v1]))] ?: costTable[(Edge(parents[v1], v1))]!!
        sumDistance += costTable[(Edge(v2, parents[v2]))] ?: costTable[(Edge(parents[v2], v2))]!!
        v1 = parents[v1]
        v2 = parents[v2]
    }

    return sumDistance
}

fun dfs(cur: Int, parent: Int, depth: Int) {
    depths[cur] = depth
    parents[cur] = parent

    for (next in connected[cur]) {
        if (next != parent) {
            dfs(next, cur, depth + 1)
        }
    }
}