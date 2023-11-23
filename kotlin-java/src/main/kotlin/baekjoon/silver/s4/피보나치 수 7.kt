package baekjoon.silver.s4

fun main() {
    val n = readln().toInt()
    if (n == 0) return println(0)
    val dp = Array(n + 1) { 0L }
    dp[1] = 1L
    for (i in 2..n) dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007
    println(dp[n])
}