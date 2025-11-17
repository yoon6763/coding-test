package baekjoon.silver.s1

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var (x, y, n) = readLine().split(" ").map { it.toInt() }
    x += 500
    y += 500

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val visited = Array(1001) { BooleanArray(1001) }

    for (i in 0..<n) {
        val (a, b) = readLine().split(" ").map { it.toInt() + 500 }
        visited[a][b] = true
    }

    val q = LinkedList<Triple<Int, Int, Int>>() as Queue<Triple<Int, Int, Int>>
    q.add(Triple(500, 500, 0))

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0..<4) {
            val nx = cur.first + dx[i]
            val ny = cur.second + dy[i]
            if (nx !in 0..1000 || ny !in 0..1000 || visited[nx][ny]) continue
            visited[nx][ny] = true

            if (nx == x && ny == y) {
                println(cur.third + 1)
                return
            }

            q.add(Triple(nx, ny, cur.third + 1))
        }
    }
}