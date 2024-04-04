package baekjoon.gold.g3.`소형기관차`

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val m = readLine().toInt()

    val arr = IntArray(n + 1)
    val acc = IntArray(n + 1)
    arr[1] = st.nextToken().toInt()
    acc[1] = arr[1]

    for (i in 2..n) {
        arr[i] = st.nextToken().toInt()
        acc[i] = arr[i] + acc[i - 1]
    }

    val dp = Array(4) { IntArray(n + 1) }

    for (i in 1..3) {
        for (j in m..n) {
            dp[i][j] = maxOf(dp[i][j - 1], dp[i - 1][j - m] + acc[j] - acc[j - m])
        }
    }

    println(dp[3][n])
}