package programmers.lv3.`경주로 건설`

import java.util.*

class Solution {
    val dx = intArrayOf(0, 1, 0, -1) // 동 남 서 북
    val dy = intArrayOf(1, 0, -1, 0)

    data class Node(val x: Int, val y: Int, val d: Int)

    fun solution(board: Array<IntArray>): Int {
        val n = board.size
        val q = LinkedList<Node>() as Queue<Node>
        val visited = Array(n) { Array(n) { Array(4) { -1 } } }

        repeat(4) {
            q.offer(Node(0, 0, it))
            visited[0][0][it] = 0
        }

        while (q.isNotEmpty()) {
            val (x, y, d) = q.poll()

            // 꺾음
            for (deltaDirection in intArrayOf(1, -1)) {
                var nd = d + deltaDirection
                if (nd > 3) nd = 0
                if (nd < 0) nd = 3

                if (visited[x][y][nd] == -1 || visited[x][y][nd] > visited[x][y][d] + 500) {
                    q.offer(Node(x, y, nd))
                    visited[x][y][nd] = visited[x][y][d] + 500
                }
            }

            // 직진
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx !in 0 until n || ny !in 0 until n || board[nx][ny] == 1) continue
            if (visited[nx][ny][d] == -1 || visited[nx][ny][d] > visited[x][y][d] + 100) {
                q.offer(Node(nx, ny, d))
                visited[nx][ny][d] = visited[x][y][d] + 100
            }
        }

        return visited[n - 1][n - 1].filter { it != -1 }.minOrNull()!!
    }
}