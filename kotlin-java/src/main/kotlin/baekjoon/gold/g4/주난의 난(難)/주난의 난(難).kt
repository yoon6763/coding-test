package baekjoon.gold.g4.`주난의 난(難)`

import java.util.PriorityQueue

data class Node(val x: Int, val y: Int, val type: Int, val depth: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val (jx, jy, tx, ty) = readLine().split(" ").map { it.toInt() - 1 }
    val map = Array(n) { readLine() }

    val q = PriorityQueue<Node> { a, b -> a.type - b.type }
    val visited = Array(n) { BooleanArray(m) }
    visited[jx][jy] = true
    q.add(Node(jx, jy, 0, 0))

    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0..<4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny]) continue
            visited[nx][ny] = true

            if (nx == tx && ny == ty) {
                println(cur.depth + 1)
                return
            }

            q.add(Node(nx, ny, cur.type + map[nx][ny].digitToInt(), cur.depth + map[nx][ny].digitToInt()))
        }
    }
}