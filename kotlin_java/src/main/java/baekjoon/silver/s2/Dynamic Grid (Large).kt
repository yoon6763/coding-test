package baekjoon.silver.s2

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    data class Node(val x: Int, val y: Int)

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        sb.appendLine("Case #${it + 1}:")

        val (r, c) = readLine().split(" ").map { it.toInt() }
        val map = Array(r) { readLine().toCharArray() }

        repeat(readLine().toInt()) {
            val cmd = StringTokenizer(readLine())
            if (cmd.nextToken() == "Q") {
                val q = LinkedList<Node>() as Queue<Node>
                val visited = Array(r) { BooleanArray(c) }
                var count = 0

                for (x in 0..<r) {
                    for (y in 0..<c) {
                        if (visited[x][y] || map[x][y] == '0') continue
                        q.offer(Node(x, y))
                        visited[x][y] = true
                        count++

                        while (q.isNotEmpty()) {
                            val cur = q.poll()
                            for (i in 0..<4) {
                                val nx = cur.x + dx[i]
                                val ny = cur.y + dy[i]
                                if (nx !in 0..<r || ny !in 0..<c || visited[nx][ny] || map[nx][ny] == '0') continue
                                q.offer(Node(nx, ny))
                                visited[nx][ny] = true
                            }
                        }
                    }
                }

                sb.appendLine(count)
            } else {
                val (x, y) = List(2) { cmd.nextToken().toInt() }
                map[x][y] = cmd.nextToken()[0]
            }
        }
    }

    print(sb)
}