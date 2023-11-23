package baekjoon.gold.g5

import kotlin.math.max

fun main() {
    val line1 = readLine()!!.toCharArray()
    val line2 = readLine()!!.toCharArray()


    val dp = Array(line1.size + 1) { Array(line2.size + 1) { 0 } }

    for (i in 1..line1.size) {
        for (j in 1..line2.size) {
            if (line1[i-1] == line2[j-1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    println(dp[line1.size][line2.size])
}