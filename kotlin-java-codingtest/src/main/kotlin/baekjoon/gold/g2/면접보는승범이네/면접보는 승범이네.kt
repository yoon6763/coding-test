package baekjoon.gold.g2.면접보는승범이네

import java.util.PriorityQueue
import java.util.StringTokenizer

data class Edge(val to: Int, val cost: Long)

fun main() = with(System.`in`.bufferedReader()) {
    val nmk = readLine().split(" ").map { it.toInt() }
    val n = nmk[0]
    val m = nmk[1]
    val k = nmk[2]

    val edges = Array(n + 1) { ArrayList<Edge>() }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (s, e, c) = Array(3) { st.nextToken().toInt() }
        edges[e].add(Edge(s, c.toLong())) // 역방향
    }

    val goal = readLine().split(" ").map { it.toInt() }
    val distance = dijkstra(n, edges, goal).map { if (it == Long.MAX_VALUE) -1 else it }
    val max = distance.maxOrNull()!!

    println(distance.indexOf(max))
    println(max)
}

fun dijkstra(n: Int, edges: Array<ArrayList<Edge>>, goal: List<Int>): LongArray {
    val distance = LongArray(n + 1) { Long.MAX_VALUE }
    val pq = PriorityQueue<Edge>(compareBy { it.cost })

    goal.forEach {
        distance[it] = 0
        pq.add(Edge(it, 0))
    }

    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (distance[cur.to] < cur.cost) continue

        edges[cur.to].forEach { next ->
            if (distance[next.to] > distance[cur.to] + next.cost) {
                distance[next.to] = distance[cur.to] + next.cost
                pq.add(Edge(next.to, distance[next.to]))
            }
        }
    }

    return distance
}