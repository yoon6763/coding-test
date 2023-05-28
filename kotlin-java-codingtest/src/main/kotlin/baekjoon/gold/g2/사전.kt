package baekjoon.gold.g2

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    var (n, m, k) = readLine().split(" ").map { it.toInt() }

    val dp = Array(202) { Array(202) { 0 } }
    for (i in 0..200) {
        for (j in 0..i) {
            if (j == 0 || j == i) {
                dp[i][j] = 1
            } else {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
                if (dp[i][j] > 1000000000) dp[i][j] = 1000000001
            }
        }
    }

    val sb = StringBuilder()

    if (dp[n + m][m] < k) sb.append(-1)
    else {
        while (!(n == 0 && m == 0)) {
            if (dp[n - 1 + m][m] >= k) {
                sb.append("a")
                n--
            } else {
                sb.append("z")
                k -= dp[n - 1 + m][m]
                m--
            }
        }
    }

    println(sb)
}