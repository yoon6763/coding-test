package baekjoon.silver.s2

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    // n 도시의 수, m 간선의 수, k 최단거리, x 출발 도시 번호
    val (n, m, k, x) = readLine().split(" ").map { it.toInt() }
    val visited = Array(n + 1) { -1 }
    val connected = Array(n + 1) { ArrayList<Int>() }

    repeat(m) {
        val st = StringTokenizer(readLine())
        connected[st.nextToken().toInt()].add(st.nextToken().toInt())
    }

    val q = LinkedList<Int>() as Queue<Int>
    q.offer(x)
    visited[x] = 0

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (next in connected[target]) {
            if (visited[next] == -1) {
                q.offer(next)
                visited[next] = visited[target] + 1
            }
        }
    }

    val sb = StringBuilder()
    for (i in 1..n) if (visited[i] == k) sb.append(i).append("\n")

    print(sb.ifEmpty { "-1" })
}
