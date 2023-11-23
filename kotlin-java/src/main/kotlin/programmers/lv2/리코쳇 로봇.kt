package programmers.lv2

import java.util.LinkedList
import java.util.Queue

data class Node(var x: Int, var y: Int)

fun solution(board: Array<String>): Int {
    val n = board.size
    val m = board[0].length

    val start = Node(-1, -1)
    val end = Node(-1, -1)

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (board[i][j] == 'R') {
                start.x = i
                start.y = j
            } else if (board[i][j] == 'G') {
                end.x = i
                end.y = j
            }
        }
    }

    val q = LinkedList<Node>() as Queue<Node>
    val visited = Array(n) { IntArray(m) { 0 } }
    q.offer(start)
    visited[start.x][start.y] = 1

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (direction in 0 until 4) {
            var nx = cur.x
            var ny = cur.y

            while (nx in 0 until n && ny in 0 until m && board[nx][ny] != 'D') {
                nx += dx[direction]
                ny += dy[direction]
            }

            nx -= dx[direction]
            ny -= dy[direction]

            if (visited[nx][ny] > 0) continue
            if (board[nx][ny] == 'G') return visited[cur.x][cur.y]

            visited[nx][ny] = visited[cur.x][cur.y] + 1
            q.offer(Node(nx, ny))
        }
    }

    return -1
}