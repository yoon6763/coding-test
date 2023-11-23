package baekjoon.gold.g5

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().toCharArray() }

    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)
    var max = 0

    repeat(n) { x ->
        repeat(m) { y ->
            if (map[x][y] == 'W') return@repeat

            val visited = Array(n) { IntArray(m) { 0 } }

            val queue = LinkedList<Pair<Int, Int>>() as Queue<Pair<Int, Int>>
            queue.add(Pair(x, y))
            visited[x][y] = 1

            while (queue.isNotEmpty()) {
                val target = queue.poll()

                for (i in 0 until 4) {
                    val nx = target.first + dx[i]
                    val ny = target.second + dy[i]

                    if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny] != 0 || map[nx][ny] == 'W') continue
                    queue.add(Pair(nx, ny))
                    visited[nx][ny] = visited[target.first][target.second] + 1

                    if (visited[nx][ny] > max) max = visited[nx][ny]
                }
            }
        }
    }

    println(max - 1)
}