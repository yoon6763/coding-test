package baekjoon.silver.s2

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val (n, m, s) = List(3) { st.nextToken().toInt() }

    val graph = Array(n) { mutableListOf<Int>() }
    var mIdx = 0

    while (mIdx < m) {
        st = StringTokenizer(readln())
        if(!st.hasMoreTokens()) continue
        val (a, b) = List(2) { st.nextToken().toInt() }
        graph[a].add(b)
        graph[b].add(a)
        mIdx++
    }

    val visited = BooleanArray(n)

    fun dfs(cur: Int) {
        visited[cur] = true
        graph[cur].forEach { next -> if (!visited[next]) dfs(next) }
    }

    dfs(s)
    println(if (visited.all { it }) "yes" else "no")
}
