package baekjoon.silver.s2.`빠른 숫자 탐색`

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val map = Array(5) { readLine().split(" ").map { it.toInt() } }
    val (x, y) = readLine().split(" ").map { it.toInt() }

    val visited = Array(5) { IntArray(5) }
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    val q = LinkedList<Node>() as Queue<Node>
    q.offer(Node(x, y))
    visited[x][y] = 1

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0..<4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0..<5 || ny !in 0..<5 || visited[nx][ny] != 0 || map[nx][ny] == -1) continue
            if (map[nx][ny] == 1) {
                println(visited[cur.x][cur.y])
                return@with
            }
            visited[nx][ny] = visited[cur.x][cur.y] + 1
            q.offer(Node(nx, ny))
        }
    }

    println(-1)
}