package baekjoon.platinum.p5.`거의 최단 경로`

import java.util.PriorityQueue
import java.util.StringTokenizer

data class Node(val to: Int, val cost: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return cost - other.cost
    }
}

var n = 0
var m = 0
var start = 0
var end = 0
lateinit var preNodes: Array<ArrayList<Int>>
lateinit var graph: Array<ArrayList<Node>>
lateinit var shortestPathVisited: Array<Array<Boolean>>

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val nm = readLine().split(" ").map { it.toInt() }
        if (nm[0] == 0 && nm[1] == 0) break
        n = nm[0]
        m = nm[1]

        val (s, e) = readLine().split(" ").map { it.toInt() }
        start = s
        end = e

        graph = Array(n) { ArrayList<Node>() }
        preNodes = Array(n) { ArrayList<Int>() }
        shortestPathVisited = Array(n) { Array(n) { false } }

        repeat(m) {
            val st = StringTokenizer(readLine())
            graph[st.nextToken().toInt()].add(Node(st.nextToken().toInt(), st.nextToken().toInt()))
        }

        dijkstra()
        disablePath(end)
        sb.append(dijkstra()).append("\n")
    }
    print(sb)
}

fun disablePath(nowNode: Int) {
    // 최단 경로에 포함되는 도로들은 모두 봉쇠함
    if (nowNode == start) return

    preNodes[nowNode].forEach { preNode ->
        if (!shortestPathVisited[preNode][nowNode]) {
            shortestPathVisited[preNode][nowNode] = true
            disablePath(preNode)
        }
    }
}

fun dijkstra(): Int {
    val distances = IntArray(n) { Int.MAX_VALUE }
    distances[start] = 0

    val pq = PriorityQueue<Node>()
    pq.add(Node(start, 0))

    while (pq.isNotEmpty()) {
        val now = pq.poll()
        if (distances[now.to] < now.cost) continue

        graph[now.to].forEach { next ->
            if (shortestPathVisited[now.to][next.to]) return@forEach

            val nextCost = now.cost + next.cost
            if (distances[next.to] == nextCost) {
                preNodes[next.to].add(now.to)
            } else if (distances[next.to] > nextCost) {
                preNodes[next.to].clear()
                preNodes[next.to].add(now.to)
                distances[next.to] = nextCost
                pq.add(Node(next.to, nextCost))
            }
        }
    }
    return if (distances[end] == Int.MAX_VALUE) -1 else distances[end]
}