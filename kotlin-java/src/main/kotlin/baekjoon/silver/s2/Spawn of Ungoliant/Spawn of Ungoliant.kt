package baekjoon.silver.s2.`Spawn of Ungoliant`

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while (true) {
        val (m, n) = readLine().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break
        val map = Array(n) { readLine().toCharArray() }

        val q = LinkedList<Node>() as Queue<Node>
        for (i in 0..<n)
            for (j in 0..<m)
                if (map[i][j] == 'S')
                    q.add(Node(i, j))

        while (q.isNotEmpty()) {
            val (x, y) = q.poll()

            for (i in 0..<4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] != 'T') continue
                map[nx][ny] = 'S'
                q.add(Node(nx, ny))
            }
        }
        sb.appendLine(map.joinToString("\n") { it.joinToString("") })
    }
    print(sb)
}