package baekjoon.gold.g5

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val inDegree = IntArray(n + 1)
    val answer = IntArray(n + 1)

    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (v1, v2) = readln().split(" ").map { it.toInt() }
        graph[v1].add(v2)
        inDegree[v2]++
    }

    val q = ArrayDeque<Int>()

    for (i in 1..n) {
        if (inDegree[i] != 0) continue
        q.offer(i)
        answer[i] = 1
    }

    while (q.isNotEmpty()) {
        val cur = q.poll()

        graph[cur].forEach { next ->
            inDegree[next]--
            if (inDegree[next] != 0) return@forEach
            q.offer(next)
            answer[next] = answer[cur] + 1
        }
    }

    println(answer.drop(1).joinToString(" "))
}
