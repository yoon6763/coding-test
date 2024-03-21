package baekjoon.gold.g2.`모래성`

import java.util.*

data class Node(val x: Int, val y: Int)

val dx = intArrayOf(1, -1, 0, 0, 1, 1, -1, -1)
val dy = intArrayOf(0, 0, 1, -1, 1, -1, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val map = Array(n) {
        val line = readLine()
        IntArray(m) { if (line[it] == '.') 0 else line[it].digitToInt() }
    }

    val q = LinkedList<Node>() as Queue<Node>
    val visited = Array(n) { BooleanArray(m) }

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (map[i][j] != 0) continue
            q.offer(Node(i, j))
            visited[i][j] = true
        }
    }

    var phase = 0

    while (q.isNotEmpty()) {
        phase++

        repeat(q.size) {
            val (x, y) = q.poll()

            for (i in 0..<8) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] == 0) continue
                map[nx][ny]--

                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true
                    q.offer(Node(nx, ny))
                }
            }
        }
    }

    println(phase - 1)
}