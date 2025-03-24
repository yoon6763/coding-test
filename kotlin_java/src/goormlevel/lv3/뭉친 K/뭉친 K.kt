package goormlevel.lv3.`뭉친 K`

import java.util.*

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val (x, y) = readLine().split(" ").map { it.toInt() - 1 }
    val map = Array(n) { readLine().split(" ").map { it.toInt() } }

    val k = map[x][y]
    val visited = Array(n) { BooleanArray(n) }

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    var ans = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] != k || visited[i][j]) continue
            var cnt = 1
            val q = LinkedList<Node>() as Queue<Node>
            q.offer(Node(i, j))
            visited[i][j] = true

            while (q.isNotEmpty()) {
                val cur = q.poll()

                for (z in 0 until 4) {
                    val nx = cur.x + dx[z]
                    val ny = cur.y + dy[z]

                    if (nx !in 0 until n || ny !in 0 until n || visited[nx][ny] || map[nx][ny] != k) continue
                    cnt++
                    visited[nx][ny] = true
                    q.offer(Node(nx, ny))
                }
            }

            ans = maxOf(ans, cnt)
        }
    }

    println(ans)
}