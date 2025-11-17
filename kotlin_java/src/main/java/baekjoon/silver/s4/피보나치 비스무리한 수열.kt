package baekjoon.silver.s4

fun main() {
    val n = readln().toInt()
    val dp = Array(n + 1) { 0L }
    if (n < 4) return println(1)
    dp.fill(1, 1, 4)
    for (i in 4..n) dp[i] = dp[i - 1] + dp[i - 3]
    println(dp[n])
}