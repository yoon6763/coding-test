package baekjoon.platinum.p5.조별과제_멈춰

import java.util.ArrayList
import java.util.PriorityQueue
import java.util.StringTokenizer

data class Edge(val u: Int, val v: Int, val weight: Int)
data class Node(val to: Int, val weight: Int)

lateinit var parent: IntArray
lateinit var dist: Array<IntArray>
lateinit var edgeOfSpanningTree: Array<ArrayList<Node>>
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    val m = nm[1]

    parent = IntArray(n + 1) { it }
    edgeOfSpanningTree = Array(n + 1) { ArrayList() }
    dist = Array(n + 1) { IntArray(n + 1) { 0 } }

    val pq = PriorityQueue<Edge>(compareBy { it.weight })

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (u, v, w) = List(3) { st.nextToken().toInt() }
        pq.offer(Edge(u, v, w))
    }

    var weightSum = 0L

    while (pq.isNotEmpty()) {
        val (u, v, w) = pq.poll()
        if (union(u, v)) {
            weightSum += w
            edgeOfSpanningTree[u].add(Node(v, w))
            edgeOfSpanningTree[v].add(Node(u, w))
        }
    }

    for (i in 1..n) {
        bfs(i)
    }

    val sb = StringBuilder()
    val questionCount = readLine().toInt()
    repeat(questionCount) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        sb.appendLine(weightSum - dist[u][v])
    }

    print(sb)
}

fun bfs(startNode: Int) {
    val visited = BooleanArray(n + 1)
    val queue = ArrayDeque<Int>()
    queue.add(startNode)
    visited[startNode] = true

    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()

        edgeOfSpanningTree[cur].forEach { nextNode ->
            if (visited[nextNode.to]) return@forEach
            visited[nextNode.to] = true
            dist[startNode][nextNode.to] =
                listOf(dist[startNode][cur], dist[startNode][nextNode.to], nextNode.weight).max()
            queue.add(nextNode.to)
        }
    }
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int): Boolean {
    val (nx, ny) = find(x) to find(y)
    if (nx != ny) {
        parent[nx] = ny
        return true
    }
    return false
}