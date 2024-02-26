package baekjoon.silver.s2.`Space Exploration`

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = Array(n) { readLine().toCharArray() }
    val visited = Array(n) { BooleanArray(n) }

    var answer = 0
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    for (i in 0..<n) {
        for (j in 0..<n) {
            if (map[i][j] == '.' || visited[i][j]) continue

            val q = LinkedList<Node>() as Queue<Node>
            q.add(Node(i, j))
            visited[i][j] = true

            while (q.isNotEmpty()) {
                val cur = q.poll()
                for (k in 0..<4) {
                    val nx = cur.x + dx[k]
                    val ny = cur.y + dy[k]
                    if (nx !in 0..<n || ny !in 0..<n || map[nx][ny] == '.' || visited[nx][ny]) continue
                    visited[nx][ny] = true
                    q.add(Node(nx, ny))
                }
            }

            answer++
        }
    }

    println(answer)
}