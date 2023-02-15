package baekjoon.silver.s1

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n + 1) { 0 }
    val dp = Array(n + 1) { 0 }

    for (i in 1..n) {
        arr[i] = readLine().toInt()
    }

    dp[1] = arr[1]

    if (n == 1) {
        println(arr[1])
        return
    }

    dp[2] = arr[1] + arr[2]

    for (i in 3..n) {
        dp[i] = max(dp[i - 1], max(arr[i] + dp[i - 2], arr[i] + arr[i - 1] + dp[i - 3]))
    }
    println(dp[n])
}