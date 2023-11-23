package baekjoon.silver.s2.트리의부모찾기

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val connect = Array(n + 1) { LinkedList<Int>() }

    repeat(n - 1) {
        val st = StringTokenizer(br.readLine(), " ")
        val p1 = st.nextToken().toInt()
        val p2 = st.nextToken().toInt()
        connect[p1].add(p2)
        connect[p2].add(p1)
    }
    val visited = Array(n + 1) { false }
    val q = LinkedList<Int>() as Queue<Int>
    q.offer(1)
    visited[1] = true

    val parent = Array(n + 1) { -1 }

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in connect[target]) {
            if (!visited[i]) {
                visited[i] = true
                q.offer(i)
                parent[i] = target
            }
        }
    }

    for (i in 2..n) {
        println(parent[i])
    }
}
