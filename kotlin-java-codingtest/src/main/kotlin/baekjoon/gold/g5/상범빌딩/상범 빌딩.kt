package baekjoon.gold.g5.상범빌딩

import java.util.LinkedList
import java.util.Queue

data class Node(val z: Int, val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val dx = intArrayOf(0, 0, 0, 0, 1, -1)
    val dy = intArrayOf(0, 0, 1, -1, 0, 0)
    val dz = intArrayOf(1, -1, 0, 0, 0, 0)

    val sb = StringBuilder()

    testcase@ while (true) {
        val (l, r, c) = readLine().split(" ").map { it.toInt() }
        if (l == 0 && r == 0 && c == 0) break

        var start: Node? = null

        val map = Array(l) { Array(r) { CharArray(c) } }

        for (i in 0 until l) {
            for (j in 0 until r) {
                val input = readLine()
                for (k in 0 until c) {
                    map[i][j][k] = input[k]
                    if (input[k] == 'S') start = Node(i, j, k)
                }
            }
            readLine()
        }

        val visited = Array(l) { Array(r) { IntArray(c) } }
        visited[start!!.z][start.x][start.y] = 1

        val queue = ArrayDeque<Node>()
        queue.addFirst(start)

        while (queue.isNotEmpty()) {
            val target = queue.removeLast()

            for (i in 0 until 6) {
                val nx = target.x + dx[i]
                val ny = target.y + dy[i]
                val nz = target.z + dz[i]

                if (nx !in 0 until r || ny !in 0 until c || nz !in 0 until l || visited[nz][nx][ny] != 0 || map[nz][nx][ny] == '#') continue

                if (map[nz][nx][ny] == 'E') {
                    sb.append("Escaped in ${visited[target.z][target.x][target.y]} minute(s).\n")
                    continue@testcase
                }

                visited[nz][nx][ny] = visited[target.z][target.x][target.y] + 1
                queue.addFirst(Node(nz, nx, ny))
            }
        }
        sb.append("Trapped!\n")
    }

    print(sb)
}