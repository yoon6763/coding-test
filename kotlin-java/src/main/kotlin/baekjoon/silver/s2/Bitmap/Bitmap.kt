package baekjoon.silver.s2.`Bitmap`

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().toCharArray().map { it.digitToInt() } }
    val answer = Array(n) { IntArray(m) { -1 } }

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    val q = LinkedList<Node>() as Queue<Node>
    for (i in 0..<n) {
        for (j in 0..<m) {
            if (map[i][j] == 1) {
                q.offer(Node(i, j))
                answer[i][j] = 0
            }
        }
    }

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()
        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0..<n && ny in 0..<m && answer[nx][ny] == -1) {
                answer[nx][ny] = answer[x][y] + 1
                q.offer(Node(nx, ny))
            }
        }
    }

    for (i in 0..<n) {
        println(answer[i].joinToString(" "))
    }
}