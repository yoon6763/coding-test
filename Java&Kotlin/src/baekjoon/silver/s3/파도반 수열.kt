package baekjoon.silver.s3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val dp = Array<Long>(102) { -1L }

    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    dp[4] = 2
    dp[5] = 2
    dp[6] = 3

    repeat(T) {
        println(find(dp, br.readLine().toInt()))
    }
}

fun find(dp: Array<Long>, n: Int): Long {
    if (dp[n] == -1L)
        dp[n] = find(dp, n - 1) + find(dp, n - 5)
    return dp[n]
}