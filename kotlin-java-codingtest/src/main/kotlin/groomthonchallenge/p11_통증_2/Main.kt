package groomthonchallenge.p11_통증_2

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val (a, b) = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n + 1) { Int.MAX_VALUE }

    dp[0] = 0

    for (i in 0..n) {
        if (i - a >= 0 && dp[i - a] != Int.MAX_VALUE) dp[i] = min(dp[i].toDouble(), (dp[i - a] + 1).toDouble()).toInt()
        if (i - b >= 0 && dp[i - b] != Int.MAX_VALUE) dp[i] = min(dp[i].toDouble(), (dp[i - b] + 1).toDouble()).toInt()
    }
    println(if (dp[n] != Int.MAX_VALUE) dp[n] else -1)
}
