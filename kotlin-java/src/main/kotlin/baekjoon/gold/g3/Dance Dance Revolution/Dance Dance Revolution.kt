package baekjoon.gold.g3.`Dance Dance Revolution`

import java.util.StringTokenizer
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())

    val n = st.countTokens() - 1
    val dp = Array(n) { Array(5) { Array(5) { Int.MAX_VALUE } } }
    val initial = st.nextToken().toInt()
    dp[0][initial][0] = 2
    dp[0][0][initial] = 2

    var idx = 0

    while (st.hasMoreTokens()) {
        // 1 - 상, 2 - 좌, 3 - 하, 4 - 우
        val cur = st.nextToken().toInt()
        if (cur == 0) break

        for (i in 0..4) {
            for (j in 0..4) {
                if (dp[idx][i][j] == Int.MAX_VALUE) continue
                dp[idx + 1][cur][j] = minOf(dp[idx + 1][cur][j], dp[idx][i][j] + getCost(i, cur))
                dp[idx + 1][i][cur] = minOf(dp[idx + 1][i][cur], dp[idx][i][j] + getCost(j, cur))
            }
        }

        idx++
    }

    var answer = Int.MAX_VALUE

    for (i in 0..4) {
        for (j in 0..4) {
            answer = minOf(answer, dp[idx][i][j])
        }
    }

    println(answer)
}

fun getCost(from: Int, to: Int): Int {
    if (from == 0) return 2
    if (from == to) return 1
    if (abs(from - to) == 2) return 4
    return 3
}