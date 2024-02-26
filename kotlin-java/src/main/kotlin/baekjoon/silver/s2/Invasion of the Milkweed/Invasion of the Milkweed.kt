package baekjoon.silver.s2.`Invasion of the Milkweed`

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

fun main() {
    val (m, n, startY, startX) = readln().split(" ").map { it.toInt() }
    val startNode = Node(n - startX, startY - 1)

    val dx = intArrayOf(1, -1, 0, 0, 1, 1, -1, -1)
    val dy = intArrayOf(0, 0, 1, -1, 1, -1, 1, -1)

    val q = LinkedList<Node>() as Queue<Node>
    val visited = Array(n) { BooleanArray(m) }

    val map = Array(n) { readln().toCharArray() }

    q.add(startNode)
    visited[startNode.x][startNode.y] = true
    var turn = 0

    while (q.isNotEmpty()) {
        turn++
        repeat(q.size) {
            val cur = q.poll()

            for (i in dx.indices) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]

                if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] == '*' || visited[nx][ny]) continue
                visited[nx][ny] = true
                q.add(Node(nx, ny))
            }
        }
    }

    println(turn - 1)
}