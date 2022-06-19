package baekjoon.silver.s3

import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()

    val dp = Array(n + 1) { 0 }
    dp[1] = 0

    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1

        if (i % 2 == 0) dp[i] = min(dp[i], dp[i / 2] + 1)
        if (i % 3 == 0) dp[i] = min(dp[i], dp[i / 3] + 1)
    }

    print(dp[n])
}