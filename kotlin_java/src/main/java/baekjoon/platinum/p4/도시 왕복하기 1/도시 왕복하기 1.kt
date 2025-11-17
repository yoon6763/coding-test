package baekjoon.platinum.p4.`도시 왕복하기 1`

import java.util.ArrayDeque
import java.util.StringTokenizer

lateinit var capacity: Array<IntArray>
lateinit var flow: Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, p) = readLine().split(" ").map { it.toInt() }
    capacity = Array(n + 1) { IntArray(n + 1) }
    flow = Array(n + 1) { IntArray(n + 1) }

    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(p) {
        val st = StringTokenizer(readLine())
        val (a, b) = st.nextToken().toInt() to st.nextToken().toInt()
        graph[a].add(b)
        graph[b].add(a)
        capacity[a][b] = 1
    }

    var total = 0L

    while (true) {
        val parent = IntArray(n + 1) { -1 }
        val queue = ArrayDeque<Int>()
        parent[1] = 1
        queue.add(1)

        while (queue.isNotEmpty() && parent[2] == -1) {
            val cur = queue.poll()
            for (next in graph[cur]) {
                if (capacity[cur][next] > flow[cur][next] && parent[next] == -1) {
                    parent[next] = cur
                    queue.add(next)
                }
            }
        }

        if (parent[2] == -1) break

        var min = Int.MAX_VALUE
        var i = 2
        while (i != 1) {
            min = min.coerceAtMost(capacity[parent[i]][i] - flow[parent[i]][i])
            i = parent[i]
        }

        i = 2
        while (i != 1) {
            flow[parent[i]][i] += min
            flow[i][parent[i]] -= min
            i = parent[i]
        }

        total += min
    }

    println(total)

}