package baekjoon.gold.g4.미로만들기

import java.util.PriorityQueue

data class Edge(val x: Int, val y: Int, val weight: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = Array(n) { readLine().toCharArray().map { it.digitToInt() } }

    val distance = dijkstra(n, map)
    println(distance[n - 1][n - 1])
}

fun dijkstra(n: Int, map: Array<List<Int>>): Array<Array<Int>> {
    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(-1, 1, 0, 0)

    val distance = Array(n) { Array(n) { Int.MAX_VALUE } }
    distance[0][0] = 0

    val pq = PriorityQueue<Edge>(compareBy { it.weight })
    pq.add(Edge(0, 0, 0))

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        for (i in 0 until 4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until n) continue

            val nWeight = cur.weight + 1 - map[nx][ny]
            if (nWeight < distance[nx][ny]) {
                distance[nx][ny] = nWeight
                pq.add(Edge(nx, ny, nWeight))
            }
        }
    }

    return distance
}