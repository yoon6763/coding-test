package baekjoon.gold.g5.십자뒤집기

import java.util.LinkedList
import java.util.Queue

val visited = IntArray(512)
val dx = intArrayOf(0, 0, 1, -1, 0)
val dy = intArrayOf(1, -1, 0, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        visited.fill(0)
        val start = List(3) { readLine().map { if (it == '*') 1 else 0 } }.flatten().joinToString("").toInt(2)
        val end = 0

        if (start == end) {
            sb.appendLine(0)
            return@repeat
        }

        val q: Queue<Int> = LinkedList()
        q.add(start)
        visited[start] = 1

        bfs@ while (q.isNotEmpty()) {
            val cur = q.poll()

            for (i in 0..<3) {
                for (j in 0..<3) {
                    var next = cur

                    for (k in 0..<5) {
                        val nx = i + dx[k]
                        val ny = j + dy[k]

                        if (nx !in 0..<3 || ny !in 0..<3) continue
                        next = next xor (1 shl (nx * 3 + ny))
                    }

                    if (next == end) {
                        sb.append("${visited[cur]}\n")
                        break@bfs
                    }

                    if (visited[next] != 0) continue
                    visited[next] = visited[cur] + 1
                    q.add(next)
                }
            }
        }
    }

    print(sb)
}