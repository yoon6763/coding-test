package baekjoon.silver.s2.알고리즘수업_깊이우선탐색1

import java.util.StringTokenizer

lateinit var connected: Array<ArrayList<Int>>
lateinit var visited: Array<Int>
val sb = StringBuilder()
var cnt = 1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }

    connected = Array(n + 1) { ArrayList() }
    visited = Array(n + 1) { -1 }

    repeat(m) {
        val st = StringTokenizer(readLine())
        connected[st.nextToken().toInt()].add(st.nextToken().toInt())
    }

    connected.forEach { it.sort() }

    dfs(r)

    for (i in 1..n) {
        sb.append(if (visited[i] == -1) 0 else visited[i]).append("\n")
    }
    print(sb)
}

fun dfs(idx: Int) {
    if (visited[idx] != -1) return

    visited[idx] = cnt++

    connected[idx].forEach { next ->
        dfs(next)
    }

}