package baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader


fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val coins = Array(n) { 0 }
    repeat(n) {
        coins[it] = readLine().toInt()
    }

    val dp = Array(k + 1) { 0 }
    dp[0] = 1

    for (coin in coins) {
        for (i in coin..k) {
            dp[i] += dp[i - coin]
        }
    }

    println(dp[k])
}