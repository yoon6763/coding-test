package baekjoon.silver.s4

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = LongArray(n) { st.nextToken().toLong() }
    val dp = LongArray(n) { arr[it] }

    for (i in 1 until n) {
        dp[i] = dp[i - 1] + arr[i]
    }

    var ans = 0L
    for (i in 0 until n - 1) {
        ans += arr[i] * (dp[n - 1] - dp[i])
    }

    println(ans)
}