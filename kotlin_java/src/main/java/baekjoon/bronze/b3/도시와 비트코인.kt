package baekjoon.bronze.b3

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    if (m == 1 && n == 1) {
        println("Yes")
        return
    }

    val map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(n) { BooleanArray(m) }

    val dx = intArrayOf(0, 1)
    val dy = intArrayOf(1, 0)

    val q = LinkedList<Pair<Int, Int>>() as Queue<Pair<Int, Int>>
    q.add(0 to 0)
    visited[0][0] = true

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()

        for (i in 0..<2) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] == 0 || visited[nx][ny]) continue

            visited[nx][ny] = true
            q.add(nx to ny)

            if (nx == n - 1 && ny == m - 1) {
                println("Yes")
                return
            }
        }
    }

    println("No")
}