package baekjoon.gold.g4.트리의지름_116

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Node(val connectedNode: Int, val w: Int)

var n = 0
lateinit var nodes: Array<ArrayList<Node>>
lateinit var visited: Array<Boolean>
var maxWeight = 0
var node = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()

    nodes = Array(n + 1) { ArrayList() }
    visited = Array(n + 1) { false }

    repeat(n) {
        val st = StringTokenizer(br.readLine(), " ")
        val node1 = st.nextToken().toInt()

        while (true) {
            val node2 = st.nextToken().toInt()
            if (node2 == -1) break
            val w = st.nextToken().toInt()

            nodes[node1].add(Node(node2, w))
        }
    }
    visited[1] = true
    dfs(1, 0)
    for(i in 1 .. n) visited[i] = false
    visited[node] = true
    dfs(node, 0)

    println(maxWeight)
}

fun dfs(nodeIdx: Int, w: Int) {
    if (w > maxWeight) {
        maxWeight = w
        node = nodeIdx
    }

    for (i in 0 until nodes[nodeIdx].size) {
        val targetNode = nodes[nodeIdx][i]

        if (visited[targetNode.connectedNode]) continue

        visited[targetNode.connectedNode] = true
        dfs(targetNode.connectedNode, targetNode.w + w)
    }
}