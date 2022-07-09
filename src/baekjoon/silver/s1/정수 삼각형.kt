package baekjoon.silver.s1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val arr = Array(n) { Array(n) { -1 } } // n번째와 n+1 번째 선택 가능
    val dp = Array(n) { Array(n) { 0 } }

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine(), " ")
        for (j in 0..i) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    if (n == 1) {
        println(arr[0][0])
        return
    }

    dp[0][0] = arr[0][0]
    dp[1][0] = arr[0][0] + arr[1][0]
    dp[1][1] = arr[0][0] + arr[1][1]

    for (i in 1 until n - 1) {
        for (j in 0..i) {
            dp[i + 1][j] = max(dp[i + 1][j], dp[i][j] + arr[i + 1][j])
            dp[i + 1][j + 1] = max(dp[i + 1][j + 1], dp[i][j] + arr[i + 1][j + 1])
        }
    }

    println(dp[n - 1].maxOrNull()!!)
}