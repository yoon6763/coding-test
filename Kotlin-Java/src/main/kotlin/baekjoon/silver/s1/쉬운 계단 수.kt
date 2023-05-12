package baekjoon.silver.s1

fun main() = with(System.`in`.bufferedReader()) {
    val div = 1000000000L
    val n = readLine().toInt()

    val dp = Array(n) { Array(10) { 0L } }

    for (i in 1..9) dp[0][i] = 1

    for (i in 1 until n) {
        dp[i][0] = dp[i - 1][1]
        dp[i][9] = dp[i - 1][8]

        for (j in 1..8) {
            dp[i][j] += dp[i - 1][j - 1]
            dp[i][j] += dp[i - 1][j + 1]
            dp[i][j] %= div
        }
    }

    println(dp[n - 1].sum() % div)
}