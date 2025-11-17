package baekjoon.silver.s2

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val arr = IntArray(n) { st.nextToken().toInt() }
    val dp = IntArray(n) { 1 }

    for (i in 1..<n) {
        for (j in 0..<i) {
            if (arr[i] > arr[j]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }

    println(dp.max())
}