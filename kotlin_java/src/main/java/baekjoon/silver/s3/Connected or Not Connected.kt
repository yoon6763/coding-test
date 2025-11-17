package baekjoon.silver.s3

import java.util.StringTokenizer

fun main() = repeat(readln().toInt()) {
    val st = StringTokenizer(readln())
    val (n, m) = IntArray(2) { st.nextToken().toInt() }
    val graph = Array(n) { mutableListOf<Int>() }

    repeat(m) {
        val (a, b) = IntArray(2) { st.nextToken().toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val visited = BooleanArray(n)

    fun dfs(cur: Int) {
        visited[cur] = true
        graph[cur].forEach { next ->
            if (visited[next]) return@forEach
            dfs(next)
        }
    }

    dfs(0)
    println("${if (visited.all { it }) "C" else "Not c"}onnected.")
}