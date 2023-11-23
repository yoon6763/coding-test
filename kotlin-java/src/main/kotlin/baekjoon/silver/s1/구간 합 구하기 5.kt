package baekjoon.silver.s1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    val arr = Array(n + 1) { Array(n + 1) { 0 } }
    val dp = Array(n + 1) { Array(n + 1) { 0 } }

    for (i in 1..n) {
        val st = StringTokenizer(br.readLine(), " ")

        for (j in 1..n) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    for (i in 1..n) {
        for (j in 1..n) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j]
        }
    }

    repeat(m) {
        val line = br.readLine().split(" ")

        val x1 = line[0].toInt()
        val y1 = line[1].toInt()
        val x2 = line[2].toInt()
        val y2 = line[3].toInt()

        println(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1])
    }
}