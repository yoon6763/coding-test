package baekjoon.gold.g4

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val (v, e, p) = readLine().split(" ").map { it.toInt() }

    data class Edge(val to: Int, val weight: Int) : Comparable<Edge> {
        override fun compareTo(other: Edge) = this.weight - other.weight
    }

    val graph = Array(v + 1) { ArrayList<Edge>() }

    repeat(e) {
        val st = StringTokenizer(readLine())
        val (v1, v2, weight) = List(3) { st.nextToken().toInt() }
        graph[v1].add(Edge(v2, weight))
        graph[v2].add(Edge(v1, weight))
    }

    val dijkstra = fun(start: Int): IntArray {
        val dist = IntArray(v + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Edge>()
        pq.add(Edge(start, 0))
        dist[start] = 0

        while (pq.isNotEmpty()) {
            val (cur, curDist) = pq.poll()
            if (dist[cur] < curDist) continue

            graph[cur].forEach { (next, weight) ->
                val nextDist = curDist + weight
                if (nextDist >= dist[next]) return@forEach
                dist[next] = nextDist
                pq.add(Edge(next, nextDist))
            }
        }

        return dist
    }

    val dist1 = dijkstra(1)
    val distP = dijkstra(p)

    println(if (dist1[v] == distP[1] + distP[v]) "SAVE HIM" else "GOOD BYE")
}