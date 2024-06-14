package baekjoon.gold.g5.`동전`

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val st = StringTokenizer(readLine())

        val coins = IntArray(n + 1)
        for (i in 1..n) {
            coins[i] = st.nextToken().toInt()
        }

        val target = readLine().toInt()

        val dp = IntArray(target + 1)

        for (i in 1..n) {
            for (j in 1..target) {
                if (j - coins[i] > 0) {
                    dp[j] = dp[j] + dp[j - coins[i]]
                } else if (j - coins[i] == 0) {
                    dp[j]++
                }
            }
        }

        sb.appendLine(dp[target])
    }
    print(sb)
}