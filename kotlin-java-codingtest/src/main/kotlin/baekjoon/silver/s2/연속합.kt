package baekjoon.silver.s2

import java.util.*
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = Array(n) { st.nextToken().toInt() }
    val dp = Array(n) { 0 }

    dp[0] = arr[0]
    var max = arr[0]

    for (i in 1 until n) {
        dp[i] = max(dp[i - 1] + arr[i], arr[i])
        max = max(max, dp[i])
    }

    println(max)
}