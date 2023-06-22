package baekjoon.gold.g5.노드사이의거리

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

var n = 0
var m = 0

data class Node(val to: Int, val cost: Int)

lateinit var connect: Array<ArrayList<Node>>

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    connect = Array(n + 1) { ArrayList() }
    repeat(n - 1) {
        val st = StringTokenizer(readLine())
        val (v1, v2, w) = Array(3) { st.nextToken().toInt() }
        connect[v1].add(Node(v2, w))
        connect[v2].add(Node(v1, w))
    }

    val sb = StringBuilder()
    repeat(m) {
        val st = StringTokenizer(readLine())
        val (start, end) = Array(2) { st.nextToken().toInt() }
        sb.append(bfs(start, end)).append("\n")
    }

    print(sb)
}

fun bfs(start: Int, end: Int): Int {
    val q = LinkedList<Int>() as Queue<Int>

    val visited = IntArray(n + 1)

    q.offer(start)
    visited[start] = 1

    while (q.isNotEmpty()) {
        val target = q.poll()

        if (target == end) return visited[target] - 1

        connect[target].forEach { next ->
            if (visited[next.to] != 0) return@forEach

            visited[next.to] = visited[target] + next.cost
            q.offer(next.to)
        }
    }

    return -1
}
