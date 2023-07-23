package baekjoon.bronze.b1

import java.math.BigInteger

fun main() {
    val n = readln().toInt()
    if (n == 0) return println(0)
    val dp = Array(n + 1) { BigInteger.ZERO }
    dp[1] = BigInteger.ONE
    for (i in 2..n) dp[i] = dp[i - 1] + dp[i - 2]
    println(dp[n])
}