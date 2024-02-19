package baekjoon.gold.g1.`도로검문`

import java.util.*

lateinit var graph: Array<ArrayList<Edge>>
lateinit var distance: IntArray
lateinit var path: IntArray

class Edge(val to: Int, val cost: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    distance = IntArray(n + 1)
    graph = Array(n + 1) { ArrayList() }

    repeat(m) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() }
        graph[from].add(Edge(to, cost))
        graph[to].add(Edge(from, cost))
    }

    path = IntArray(n + 1) { -1 }

    val shortPath = dijkstra(graph, distance, path)
    var maxPath = 0
    var i = n
    while (i > 0) {
        maxPath = maxPath.coerceAtLeast(dijkstra(graph, distance, path[i], i))
        i = path[i]
    }

    println(if (maxPath == Int.MAX_VALUE) -1 else maxPath - shortPath)
}

fun dijkstra(graph: Array<ArrayList<Edge>>, distance: IntArray, path: IntArray): Int {
    distance.fill(Int.MAX_VALUE)
    distance[1] = 0

    val q = PriorityQueue<Edge> { a, b -> a.cost - b.cost }
    q.add(Edge(1, 0))

    while (q.isNotEmpty()) {
        val cur = q.poll()
        if (cur.cost > distance[cur.to]) continue

        for (next in graph[cur.to]) {
            if (distance[next.to] > distance[cur.to] + next.cost) {
                distance[next.to] = distance[cur.to] + next.cost
                q.add(Edge(next.to, distance[next.to]))
                path[next.to] = cur.to
            }
        }
    }

    return distance[distance.size - 1]
}

fun dijkstra(graph: Array<ArrayList<Edge>>, distance: IntArray, a: Int, b: Int): Int {
    distance.fill(Int.MAX_VALUE)
    distance[1] = 0

    val q = PriorityQueue<Edge> { a, b -> a.cost - b.cost }
    q.add(Edge(1, 0))

    while (q.isNotEmpty()) {
        val cur = q.poll()
        if (cur.cost > distance[cur.to]) continue

        for (next in graph[cur.to]) {
            if (a == cur.to && b == next.to) continue
            if (distance[next.to] > distance[cur.to] + next.cost) {
                distance[next.to] = distance[cur.to] + next.cost
                q.add(Edge(next.to, distance[next.to]))
            }
        }
    }
    return distance[distance.size - 1]
}