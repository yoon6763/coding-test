package baekjoon.silver.s2

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n + 1)
    val st = StringTokenizer(readLine())
    for (i in 1..n) arr[i] = st.nextToken().toInt()
    val dp = IntArray(n + 1) { 0 }

    dp[1] = arr[1]

    for (i in 2..n) {
        for (j in 0 until i) {
            if (arr[i] > arr[j] && dp[i] <= dp[j] + arr[i]) dp[i] = dp[j] + arr[i]
        }
    }
    println(dp.maxOrNull()!!)
}