package baekjoon.gold.g3

import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { Array(2) { 0 } }

    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        arr[it][0] = a
        arr[it][1] = b
    }

    val dp = Array(n) { Array(n) { 0 } }

    for (k in 1 until n) {
        for (i in 0 until n - k) {
            dp[i][i+k] = Int.MAX_VALUE
            for (j in i until i + k) {
                dp[i][i + k] = min(dp[i][i + k], dp[i][j] + dp[j + 1][i + k] + arr[i][0] * arr[j][1] * arr[i + k][1])
            }
        }
    }

    println(dp[0][n - 1])
}