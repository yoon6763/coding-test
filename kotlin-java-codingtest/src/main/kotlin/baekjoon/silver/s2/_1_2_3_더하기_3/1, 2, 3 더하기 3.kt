package baekjoon.silver.s2._1_2_3_더하기_3

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = LongArray(1000001)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for (i in 4..1000000) dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009
    for (i in 0 until n) {
        println(dp[readLine().toInt()])
    }
}