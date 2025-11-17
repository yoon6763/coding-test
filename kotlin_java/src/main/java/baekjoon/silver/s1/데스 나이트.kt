package baekjoon.silver.s1

import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().toInt()
    val (sx, sy, ex, ey) = readln().split(" ").map { it.toInt() }

    val dx = intArrayOf(-2, -2, 0, 0, 2, 2)
    val dy = intArrayOf(-1, 1, -2, 2, -1, 1)
    val visited = Array(n) { IntArray(n) }

    val q = LinkedList<Pair<Int, Int>>() as Queue<Pair<Int, Int>>
    q.offer(Pair(sx, sy))
    visited[sx][sy] = 1

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in 0 until 6) {
            val nx = dx[i] + target.first
            val ny = dy[i] + target.second

            if (nx !in 0 until n || ny !in 0 until n || visited[nx][ny] != 0) continue

            visited[nx][ny] = visited[target.first][target.second] + 1
            q.offer(Pair(nx, ny))

            if (nx == ex && ny == ey) {
                println(visited[nx][ny] - 1)
                return
            }
        }
    }
    println(-1)
}