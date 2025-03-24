package baekjoon.silver.s1

fun main() = with(System.`in`.bufferedReader()) {
    val mod = 9901
    val n = readLine().toInt()

    val dp = Array(n + 1) { LongArray(3) }
    dp[1].fill(1)

    for (i in 2..n) {
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod
    }

    println(dp[n].sum() % mod)
}