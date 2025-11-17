package baekjoon.silver.s2

fun main() = with(System.`in`.bufferedReader()) {
    val MOD = 1000000009
    val dp = Array(100001) { LongArray(4) }

    dp[1][1] = 1
    dp[2][2] = 1
    dp[3][1] = 1
    dp[3][2] = 1
    dp[3][3] = 1

    for (i in 4..dp.lastIndex) {
        dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD
        dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD
        dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD
    }

    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        sb.appendLine((dp[n][1] + dp[n][2] + dp[n][3]) % MOD)
    }

    print(sb)
}