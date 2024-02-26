package baekjoon.silver.s3.`10451 순열 사이클`

import java.util.StringTokenizer

lateinit var next: IntArray
lateinit var visited: BooleanArray
var n = 0
var cnt = 0

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val st = StringTokenizer("0 ${readLine()}")
        next = IntArray(n + 1) { st.nextToken().toInt() }
        visited = BooleanArray(n + 1)
        cnt = 0

        for (i in 1..n) {
            if (!visited[i]) dfs(i)
        }
        println(cnt)
    }
}

fun dfs(cur: Int) {
    visited[cur] = true
    if (!visited[next[cur]]) {
        dfs(next[cur])
    } else {
        cnt++
    }
}