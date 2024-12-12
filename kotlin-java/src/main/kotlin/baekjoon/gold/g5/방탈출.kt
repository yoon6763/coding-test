package baekjoon.gold.g5

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    data class Node(val x: Int, val y: Int)
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    var maxDistance = 0
    var answer = 0

    repeat(n) { i ->
        repeat(m) { j ->
            if (board[i][j] == 0) return@repeat
            val visited = Array(n) { IntArray(m) { 0 } }
            val q = LinkedList<Node>() as Queue<Node>
            q.add(Node(i, j))
            visited[i][j] = 1

            while (q.isNotEmpty()) {
                val (x, y) = q.poll()

                for (k in 0..<4) {
                    val nx = x + dx[k]
                    val ny = y + dy[k]

                    if (nx !in 0..<n || ny !in 0..<m || board[nx][ny] == 0 || visited[nx][ny] != 0) continue

                    visited[nx][ny] = visited[x][y] + 1
                    q.add(Node(nx, ny))

                    if (visited[nx][ny] > maxDistance) {
                        maxDistance = visited[nx][ny]
                        answer = board[nx][ny] + board[i][j]
                    }

                    if (visited[nx][ny] == maxDistance) {
                        answer = maxOf(answer, board[nx][ny] + board[i][j])
                    }
                }
            }
        }
    }

    println(answer)
}