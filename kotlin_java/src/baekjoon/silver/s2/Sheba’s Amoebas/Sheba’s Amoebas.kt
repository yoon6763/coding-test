package baekjoon.silver.s2.`Sheba’s Amoebas`

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().toCharArray() }
    val visited = Array(n) { BooleanArray(m) }

    val dx = intArrayOf(1, -1, 0, 0, 1, 1, -1, -1)
    val dy = intArrayOf(0, 0, 1, -1, 1, -1, 1, -1)

    var answer = 0

    val q = LinkedList<Node>() as Queue<Node>
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (visited[i][j] || map[i][j] == '.') continue
            answer++
            q.offer(Node(i, j))
            visited[i][j] = true

            while (q.isNotEmpty()) {
                val cur = q.poll()
                for (k in 0 until 8) {
                    val nx = cur.x + dx[k]
                    val ny = cur.y + dy[k]
                    if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny] || map[nx][ny] == '.') continue
                    q.offer(Node(nx, ny))
                    visited[nx][ny] = true
                }
            }
        }
    }

    println(answer)
}