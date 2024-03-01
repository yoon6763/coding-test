package baekjoon.gold.g2.`우수 마을`

import java.util.StringTokenizer

lateinit var connected: Array<ArrayList<Int>>
lateinit var dp: Array<Array<Int>>
lateinit var scores: Array<Int>

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()

    connected = Array(n + 1) { ArrayList() }
    dp = Array(n + 1) { Array(2) { 0 } }

    val st = StringTokenizer(readLine())
    scores = Array(n + 1) { if (it == 0) 0 else st.nextToken().toInt() }

    repeat(n - 1) {
        val st = StringTokenizer(readLine())
        val (a, b) = Array(2) { st.nextToken().toInt() }
        connected[a].add(b)
        connected[b].add(a)
    }

    dfs(1, 0)

    println(maxOf(dp[1][0], dp[1][1]))
}

fun dfs(idx: Int, parent: Int) {
    connected[idx].forEach { node ->
        if (parent != node) {
            dfs(node, idx)
            dp[idx][0] += maxOf(dp[node][0], dp[node][1])
            dp[idx][1] += dp[node][0]
        }
    }
    dp[idx][1] += scores[idx]
}