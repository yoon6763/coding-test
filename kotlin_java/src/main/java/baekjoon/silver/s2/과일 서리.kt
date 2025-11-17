package baekjoon.silver.s2

import java.util.*

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val dp = Array(n) { IntArray(m) }
    Arrays.fill(dp[0], 1)

    for (i in 1 until n) {
        for (j in i until m) {
            dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1]
        }
    }
    println(dp[n - 1][m - 1])
}