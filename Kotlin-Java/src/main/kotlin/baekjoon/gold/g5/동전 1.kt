package baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min


fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val MAX = 1000000
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val coins = Array(n) { 0 }
    repeat(n) {
        coins[it] = readLine().toInt()
    }

    val dp = Array(k + 1) { MAX }
    dp[0] = 0

    for (i in 1..k) {
        for (coin in coins) {
            if (i - coin >= 0) {
                dp[i] = min(dp[i], dp[i - coin] + 1)
            }
        }
    }
    println(if (dp[k] == MAX) -1 else dp[k])
}