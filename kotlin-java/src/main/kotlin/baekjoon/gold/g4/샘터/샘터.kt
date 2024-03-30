package baekjoon.gold.g4.`샘터`

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val visited = HashMap<Long, Long>()
    val q = LinkedList<Long>() as Queue<Long>

    readLine().split(" ").map { it.toLong() }.forEach {
        q.add(it)
        visited[it] = 0L
    }

    var cnt = 0

    bfs@ while (q.isNotEmpty()) {
        val cur = q.poll()

        for (next in listOf(cur - 1, cur + 1)) {
            if (next in visited) continue
            visited[next] = visited[cur]!! + 1
            q.add(next)
            cnt++

            if (cnt == k) {
                break@bfs
            }
        }
    }

    println(visited.values.sum())
}