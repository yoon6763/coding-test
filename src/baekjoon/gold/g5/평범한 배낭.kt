package baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nk = br.readLine().split(" ")
    val n = nk[0].toInt()
    val k = nk[1].toInt() // 버틸 수 있는 무게
    val dp = Array(n + 1) { Array(k + 1) { 0 } }

    val objs = Array(n + 1) { Array(2) { 0 } } // 0 - 무게, 1 - 가치

    repeat(n) {
        val line = br.readLine().split(" ")
        objs[it + 1][0] = line[0].toInt()
        objs[it + 1][1] = line[1].toInt()
    }

    for (i in 1..n) {
        for (j in 1..k) {
            if (j - objs[i][0] >= 0)
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - objs[i][0]] + objs[i][1])
            else
                dp[i][j] = dp[i - 1][j]
        }
    }

    println(dp[n][k])
}