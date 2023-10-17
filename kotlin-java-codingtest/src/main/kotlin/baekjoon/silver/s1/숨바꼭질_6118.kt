package baekjoon.silver.s1

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { ArrayList<Int>() }

    repeat(m) {
        val (v1, v2) = readLine().split(" ").map { it.toInt() }
        graph[v1].add(v2)
        graph[v2].add(v1)
    }

    val visited = IntArray(n + 1) { 0 }
    val queue = LinkedList<Int>() as Queue<Int>
    queue.offer(1)
    visited[1] = 1

    var maxDepth = 0

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        graph[cur].forEach { next ->
            if (visited[next] != 0) return@forEach

            visited[next] = visited[cur] + 1
            queue.offer(next)

            maxDepth = maxOf(maxDepth, visited[next])
        }
    }

    val targetNodeCnt = visited.count { it == maxDepth }
    val targetNode = visited.indexOf(maxDepth)

    println("$targetNode ${maxDepth - 1} $targetNodeCnt")
}