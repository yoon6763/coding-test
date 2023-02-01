package baekjoon.silver.s3

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = Array(n + 1) { 0L }
    dp[1] = 1

    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    println(dp[n])
}