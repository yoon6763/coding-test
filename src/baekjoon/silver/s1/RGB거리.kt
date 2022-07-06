package baekjoon.silver.s1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dp = Array(n + 1) { arrayOf(0, 0, 0) } // 이전 RGB를 담음
    val rgb = Array(n + 1) { arrayOf(0, 0, 0) }

    for (i in 1..n) {
        val st = StringTokenizer(br.readLine(), " ")
        repeat(3) { it2 -> rgb[i][it2] = st.nextToken().toInt() }
    }

    dp[1][0] = rgb[1][0]
    dp[1][1] = rgb[1][1]
    dp[1][2] = rgb[1][2]

    for (i in 2..n) {
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0]
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1]
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2]
    }

    println(dp[n].minOrNull()!!)
}