package baekjoon.silver.s2.`친구`

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val graph = Array(n) {
        val line = readLine()
        BooleanArray(n) { line[it] == 'Y' }
    }

    var answer = 0

    for (i in 0..<n) {
        val visited = IntArray(n)
        var cnt = 1
        val q = LinkedList<Int>() as Queue<Int>
        visited[i] = 1
        q.offer(i)

        bfs@ while (q.isNotEmpty()) {
            val cur = q.poll()
            if (visited[cur] > 2) break@bfs

            for (j in 0..<n) {
                if (!graph[cur][j] || visited[j] != 0) continue
                visited[j] = visited[cur] + 1
                cnt++
                q.offer(j)
            }
        }

        answer = maxOf(answer, cnt)
    }

    println(answer - 1)
}