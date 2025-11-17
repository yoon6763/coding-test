package baekjoon.platinum.p5.`숨바꼭질 5`

import java.util.*

data class Node(val distance: Int, val time: Int)

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val maxPoint = 500000
    val visited = Array(2) { IntArray(maxPoint + 1) { -1 } }

    val queue = LinkedList<Node>() as Queue<Node>
    queue.offer(Node(n, 0))
    visited[0][n] = 0

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        for (nx in arrayOf(cur.distance - 1, cur.distance + 1, cur.distance * 2)) {
            val nTime = cur.time + 1

            if (nx !in 0..maxPoint) continue
            if (visited[nTime % 2][nx] != -1 && visited[nTime % 2][nx] <= nTime) continue

            visited[nTime % 2][nx] = nTime
            queue.offer(Node(nx, nTime))
        }
    }

    var time = 0
    var distance = k

    while (distance <= maxPoint) {
        if (visited[time % 2][distance] != -1 && visited[time % 2][distance] <= time) {
            println(time)
            return
        }
        time++
        distance += time
    }

    println(-1)
}