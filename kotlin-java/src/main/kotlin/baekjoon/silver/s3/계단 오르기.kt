package baekjoon.silver.s3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n + 1) { 0 }
    val dp = Array(n + 1) { 0 }

    for (i in 1..n) {
        arr[i] = br.readLine().toInt()
    }

    dp[1] = arr[1]
    if (n == 1) {
        println(dp[1])
        return
    }
    dp[2] = arr[2] + arr[1]
    if (n == 2) {
        println(dp[2])
        return
    }
    dp[3] = max(arr[1] + arr[3], arr[2] + arr[3])
    if (n == 3) {
        println(dp[3])
        return
    }
    for (i in 4..n) {
        dp[i] = max(arr[i] + dp[i - 2], arr[i] + arr[i - 1] + dp[i - 3])
    }
    println(dp[n])
}