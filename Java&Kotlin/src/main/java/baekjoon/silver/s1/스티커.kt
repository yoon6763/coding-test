package baekjoon.silver.s1

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    repeat(T) {
        val n = br.readLine().toInt()

        val line1 = br.readLine().split(" ")
        val line2 = br.readLine().split(" ")
        val arr = Array(2) { Array(n + 1) { 0 } }
        val dp = Array(2) { Array(n + 1) { 0 } }

        for (i in 1..n) {
            arr[0][i] = line1[i - 1].toInt()
            arr[1][i] = line2[i - 1].toInt()
        }

        dp[0][1] = arr[0][1]
        dp[1][1] = arr[1][1]

        for (i in 2..n) {
            dp[0][i] = max(dp[1][i - 2], dp[1][i - 1]) + arr[0][i]
            dp[1][i] = max(dp[0][i - 2], dp[0][i - 1]) + arr[1][i]
        }
        println(max(dp[0][n], dp[1][n]))
    }
}