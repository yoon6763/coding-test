package baekjoon.silver.s3

import kotlin.math.min
import kotlin.math.sqrt

fun main() {
    val n = readLine()!!.toInt()
    val root = sqrt(n.toDouble()).toInt()

    val dp = Array(n + 1) { 0 }
    dp[1] = 1

    for (i in 2 until n + 1) {
        dp[i] = dp[i - 1] + dp[1]

        for (j in 2 .. i) {
            if(j*j > i) {
                break
            }
            dp[i] = min(dp[i], dp[i - j * j] + 1)
        }
    }
    println(dp[n])
}