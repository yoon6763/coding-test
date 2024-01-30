package baekjoon.gold.g4.`트리의 지름 1967`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Node(val connectedNode: Int, val w: Int)

var n = 0
lateinit var nodes: Array<ArrayList<Node>>
lateinit var visited: Array<Boolean>
var maxWeight = 0


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()

    nodes = Array(n + 1) { ArrayList() }
    visited = Array(n + 1) { false }

    repeat(n - 1) {
        val st = StringTokenizer(br.readLine(), " ") // parent, child, weight
        val p = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        val w = st.nextToken().toInt()

        nodes[p].add(Node(c, w))
        nodes[c].add(Node(p, w))
    }

    for (i in 1..n) {
        for (j in 1..n) visited[j] = false
        visited[i] = true
        dfs(i, 0)
    }

    println(maxWeight)
}

fun dfs(nodeIdx: Int, w: Int) {
    if (w > maxWeight) {
        maxWeight = w
    }

    for (i in 0 until nodes[nodeIdx].size) {
        val targetNode = nodes[nodeIdx][i]

        if (visited[targetNode.connectedNode]) continue

        visited[targetNode.connectedNode] = true
        dfs(targetNode.connectedNode, targetNode.w + w)
    }
}