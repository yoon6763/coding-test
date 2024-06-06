package baekjoon.silver.s4.`Emacs`

import java.util.*

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine() }
    val visited = Array(n) { BooleanArray(m) }

    val q = LinkedList<Node>() as Queue<Node>
    var ans = 0

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == '*' && !visited[i][j]) {
                ans++

                q.offer(Node(i, j))
                visited[i][j] = true

                while (q.isNotEmpty()) {
                    val cur = q.poll()

                    for (k in 0 until 4) {
                        val nx = cur.x + dx[k]
                        val ny = cur.y + dy[k]

                        if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny] || map[nx][ny] == '.') continue
                        visited[nx][ny] = true
                        q.offer(Node(nx, ny))
                    }
                }
            }
        }
    }

    println(ans)
}