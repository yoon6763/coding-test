package baekjoon.gold.g2.`미확인 도착지`

import java.util.*
import kotlin.collections.ArrayList

class Node(val index: Int, val cost: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return (this.cost - other.cost)
    }
}

var n = 0
var m = 0
var t = 0
var s = 0
var g = 0
var h = 0

lateinit var graph: Array<ArrayList<Node>>
lateinit var candidate: Array<Int>

fun main() = with(System.`in`.bufferedReader()) {

    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        var st = StringTokenizer(readLine())
        n = st.nextToken().toInt()
        m = st.nextToken().toInt()
        t = st.nextToken().toInt()

        // s - 예술가 출발지, g - h 구간
        st = StringTokenizer(readLine())
        s = st.nextToken().toInt()
        g = st.nextToken().toInt()
        h = st.nextToken().toInt()


        graph = Array(n + 1) { ArrayList<Node>() }
        repeat(m) {
            st = StringTokenizer(readLine())
            val (a, b, d) = Array(3) { st.nextToken().toInt() }
            graph[a].add(Node(b, d))
            graph[b].add(Node(a, d))
        }

        // 목적지 후보들
        candidate = Array(t) { readLine().toInt() }.sortedArray()

        val goals = ArrayList<Int>()

        // 다익스트라
        candidate.forEach { target ->
            val shortestLength = dijkstra(s, target)
            val path1 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, target)
            val path2 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, target)

            if (shortestLength == path1 || shortestLength == path2) {
                goals.add(target)
            }
        }

        goals.sorted().forEach {
            sb.append(it).append(" ")
        }
        sb.append("\n")
    }

    print(sb)
}


fun dijkstra(start: Int, end: Int): Int {
    val dist = Array(n + 1) { Int.MAX_VALUE }
    dist[start] = 0

    val pq = PriorityQueue<Node>()
    pq.offer(Node(start, 0))

    while (pq.isNotEmpty()) {
        val nowNode = pq.poll()
        if (nowNode.cost > dist[nowNode.index]) continue

        graph[nowNode.index].forEach { nextNode ->
            if (dist[nextNode.index] > nowNode.cost + nextNode.cost) {
                dist[nextNode.index] = nowNode.cost + nextNode.cost
                pq.offer(Node(nextNode.index, nowNode.cost + nextNode.cost))
            }
        }
    }

    return dist[end]
}