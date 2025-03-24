package baekjoon.platinum.p5.`도로포장`

import java.util.PriorityQueue
import java.util.StringTokenizer

data class Edge(val to: Int, val cost: Long, var paveCount: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Edge>() }
    var st: StringTokenizer
    repeat(m) {
        st = StringTokenizer(readLine())
        val (from, to, cost) = List(3) { st.nextToken().toInt() }
        graph[from].add(Edge(to, cost.toLong(), 0))
        graph[to].add(Edge(from, cost.toLong(), 0))
    }

    val distance = Array(n + 1) { LongArray(k + 1) { Long.MAX_VALUE } }
    distance[1][0] = 0

    val pq = PriorityQueue<Edge>(compareBy { it.cost })
    pq.offer(Edge(1, 0, 0))
    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        if (cur.cost > distance[cur.to][cur.paveCount]) {
            continue
        }

        graph[cur.to].forEach { next ->
            if (cur.paveCount < k && distance[next.to][cur.paveCount + 1] > distance[cur.to][cur.paveCount]) {
                distance[next.to][cur.paveCount + 1] = distance[cur.to][cur.paveCount]
                pq.add(Edge(next.to, distance[next.to][cur.paveCount + 1], cur.paveCount + 1))
            }

            if (distance[next.to][cur.paveCount] > distance[cur.to][cur.paveCount] + next.cost) {
                distance[next.to][cur.paveCount] = distance[cur.to][cur.paveCount] + next.cost
                pq.offer(Edge(next.to, distance[next.to][cur.paveCount], cur.paveCount))
            }
        }
    }

    println(distance[n].minOrNull()!!)
}