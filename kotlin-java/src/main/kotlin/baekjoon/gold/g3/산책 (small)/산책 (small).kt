package baekjoon.gold.g3.`산책 (small)`

import java.util.*

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: IntArray
lateinit var pre: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { ArrayList<Int>() }
    visited = IntArray(n + 1)
    pre = IntArray(n + 1)

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (a, b) = IntArray(2) { st.nextToken().toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    graph.forEach { it.sort() }

    val (start, end) = readLine().split(" ").map { it.toInt() }
    val firstDistance = bfs(start, end)
    visited.fill(0)

    var preNode = end
    while (preNode != start) {
        visited[preNode] = 1
        preNode = pre[preNode]
    }

    val secondDistance = bfs(end, start)
    println(firstDistance + secondDistance)
}

fun bfs(start: Int, end: Int): Int {
    val q = LinkedList<Int>() as Queue<Int>
    q.add(start)
    visited[start] = 1

    while (q.isNotEmpty()) {
        val cur = q.poll()

        graph[cur].forEach { next ->
            if (visited[next] != 0) return@forEach
            visited[next] = visited[cur] + 1
            pre[next] = cur
            q.add(next)

            if (next == end) return visited[next] - 1
        }
    }

    return -1
}