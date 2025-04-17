package baekjoon.silver.s2.`Neighborhoods in Graphs`

import java.util.StringTokenizer

fun main() = repeat(readln().trim().toInt()) {
    val st = StringTokenizer(readln())
    val (n, m) = List(2) { st.nextToken().toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (a, b) = List(2) { st.nextToken().drop(1).toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val start = st.nextToken().drop(1).toInt()
    val visited = BooleanArray(n + 1)

    val q = ArrayDeque<Int>()
    q.add(start)
    visited[start] = true

    repeat(2) {
        repeat(q.size) {
            graph[q.removeFirst()].forEach {
                visited[it] = true
                q.add(it)
            }
        }
    }

    println("The number of supervillains in 2-hop neighborhood of v$start is ${visited.count { it } - 1}")
}