package baekjoon.gold.g3.`사회망 서비스 (SNS)`

import java.util.*
import kotlin.math.min

lateinit var visited: Array<Boolean>
lateinit var connected: Array<ArrayList<Int>>
lateinit var dp: Array<Array<Int>>

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    visited = Array(n + 1) { false }
    connected = Array(n + 1) { ArrayList() }
    dp = Array(n + 1) { Array(2) { 0 } }

    repeat(n - 1) {
        val st = StringTokenizer(readLine())
        val (a, b) = Array(2) { st.nextToken().toInt() }
        connected[a].add(b)
        connected[b].add(a)
    }

    dfs(1)
    println(min(dp[1][0], dp[1][1]))
}

fun dfs(index: Int) {
    dp[index][0] = 0
    dp[index][1] = 1

    visited[index] = true

    for (next in connected[index]) {
        if (!visited[next]) {
            dfs(next)
            dp[index][0] += dp[next][1]
            dp[index][1] += min(dp[next][0], dp[next][1])
        }
    }
}