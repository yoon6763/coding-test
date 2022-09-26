package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val dp = Array(n + 1) { arrayOf(0, 0, 0) }
    val arr = Array(n + 1) { arrayOf(0, 0, 0) }

    for (i in 1..n) {
        val rgb = br.readLine().split(" ").map { it.toInt() }
        arr[i][0] = rgb[0]
        arr[i][1] = rgb[1]
        arr[i][2] = rgb[2]
    }

    val MAX = 100000000

    var result = MAX

    for (i in 0 until 3) {
        for(j in 0 until 3) {
            if(i == j) dp[1][j] = arr[1][j]
            else dp[1][j] = MAX
        }

        for (j in 2..n) {
            dp[j][0] = min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0]
            dp[j][1] = min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1]
            dp[j][2] = min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2]
        }

        for(j in 0 until 3) {
            if(i != j) {
                result = min(result, dp[n][j])
            }
        }
    }

    println(result)
}