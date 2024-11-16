package baekjoon.gold.g4

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { IntArray(n + 1) }
    for (i in 0..<k) {
        val (u, v, w) = readLine().split(" ").map { it.toInt() }
        graph[u][v] = max(graph[u][v], w)
    }

    val dp = Array(m + 1) { IntArray(n + 1) { -1 } }
    dp[1][1] = 0

    for (i in 1..m) {
        for (j in 1..n) {
            for (k in 1..<j) {
                if (graph[j - k][j] == 0 || dp[i - 1][j - k] == -1) continue
                dp[i][j] = max(dp[i][j], dp[i - 1][j - k] + graph[j - k][j])
            }
        }
    }

    println((0..m).maxOf { dp[it][n] })
}
