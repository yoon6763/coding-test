package baekjoon.gold.g3.파티

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

val MAX = 1000000000
var n = 0

class Node(val node: Int, val weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return (this.weight - other.weight)
    }
}


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nmx = br.readLine().split(" ").map { it.toInt() } // n - 학생 수, m - 간선 수, x - 목표 마을
    n = nmx[0]
    val m = nmx[1]
    val x = nmx[2]

    val connected = Array(n + 1) { ArrayList<Node>() }
    val reversedConnected = Array(n + 1) { ArrayList<Node>() }

    repeat(m) {
        val st = StringTokenizer(br.readLine(), " ")
        val (from, to, w) = Array(3) { st.nextToken().toInt() }
        connected[from].add(Node(to, w))
        reversedConnected[to].add(Node(from, w))
    }

    val distance = dijkstra(x, connected)
    val reverseDistance = dijkstra(x, reversedConnected)

    var result = 0
    for (i in 1..n) result = max(result, distance[i] + reverseDistance[i])

    println(result)
}


private fun dijkstra(start: Int, connection: Array<ArrayList<Node>>): Array<Int> {
    val pq = PriorityQueue<Node>()
    val distance = Array(n + 1) { MAX }
    val visited = Array(n + 1) { false }

    distance[start] = 0
    pq.offer(Node(start, 0))

    while (pq.isNotEmpty()) {
        val target = pq.poll()

        if (visited[target.node]) continue
        visited[target.node] = true

        connection[target.node].forEach { next ->
            if (distance[next.node] > next.weight + target.weight) {
                distance[next.node] = next.weight + target.weight
                pq.offer(Node(next.node, distance[next.node]))
            }
        }
    }

    return distance
}

/*
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
 */