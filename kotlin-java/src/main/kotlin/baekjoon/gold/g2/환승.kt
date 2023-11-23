package baekjoon.gold.g2

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    // n: 역 개수, k : 하이퍼 튜브가 연결하는 역 개수, m : 하이퍼 튜브 개수
    val (n, k, m) = readLine().split(" ").map { it.toInt() }

    val graph = Array(n + m + 1) { mutableListOf<Int>() }

    repeat(m) { i ->
        val st = StringTokenizer(readLine())
        repeat(k) { j ->
            val node = st.nextToken().toInt()
            graph[node].add(n + i + 1)
            graph[n + i + 1].add(node)
        }
    }

    val visited = IntArray(n + m + 1)
    val q = LinkedList<Int>() as Queue<Int>
    visited[1] = 1
    q.offer(1)

    while (q.isNotEmpty()) {
        val target = q.poll()

        if (target == n) {
            println(visited[target] / 2 + 1)
            return
        }

        graph[target].forEach { next ->
            if (visited[next] != 0) return@forEach

            visited[next] = visited[target] + 1
            q.offer(next)
        }
    }

    println(-1)
}