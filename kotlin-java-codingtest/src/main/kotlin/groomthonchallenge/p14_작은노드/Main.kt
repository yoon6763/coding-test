package groomthonchallenge.p14_작은노드

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M, K) = readLine().split(" ").map { it.toInt() }
    val graph = Array(N + 1) { ArrayList<Int>() }

    for (i in 0 until M) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        graph[s].add(e)
        graph[e].add(s)
    }
    graph.forEach { it.sort() }

    val visited = IntArray(N + 1)
    val q: Queue<Int> = LinkedList()
    q.add(K)

    var cnt = 0
    var last = K

    while (!q.isEmpty()) {
        last = q.poll()
        visited[last] = 1
        cnt++

        for (nextNode in graph[last]) {
            if (visited[nextNode] == 0) {
                q.add(nextNode)
                break
            }
        }
    }

    println("$cnt $last")
}
