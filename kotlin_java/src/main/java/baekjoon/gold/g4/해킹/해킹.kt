package baekjoon.gold.g4.해킹

import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.math.max

const val MAX = 987654321
var n = 0
lateinit var graph: Array<ArrayList<Node>>
lateinit var distance: Array<Int>

data class Node(var vertex: Int, var weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.weight - other.weight
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    repeat(br.readLine().toInt()) {
        // 컴퓨터 개수, 의존성 개수, 해킹당한 컴퓨터
        var st = StringTokenizer(br.readLine())
        n = st.nextToken().toInt()
        val d = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        distance = Array(n + 1) { MAX }
        graph = Array(n + 1) { ArrayList() }

        repeat(d) {
            st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            graph[b].add(Node(a, st.nextToken().toInt()))
        }

        dijkstra(c)

        var infested = 0
        var maxTime = 0

        for(i in 1 .. n) {
            if(distance[i] != MAX) {
                infested++
                maxTime = max(maxTime, distance[i])
            }
        }
        sb.append("$infested $maxTime\n")

    }
    print(sb)
}


fun dijkstra(start: Int) {
    val pq = PriorityQueue<Node>()

    pq.offer(Node(start, 0))
    distance[start] = 0

    while (pq.isNotEmpty()) {
        val nowNode = pq.poll()
        if (distance[nowNode.vertex] < nowNode.weight) continue

        graph[nowNode.vertex].forEach { nextNode ->
            if (distance[nextNode.vertex] > distance[nowNode.vertex] + nextNode.weight) {
                distance[nextNode.vertex] = distance[nowNode.vertex] + nextNode.weight
                pq.offer(Node(nextNode.vertex, distance[nextNode.vertex]))
            }
        }
    }
}

