package baekjoon.silver.s3._1_2_3_더하기

val dp = Array(11) { -1 }

fun main() {
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 0 until readLine()!!.toInt()) {
        println(funDP(readLine()!!.toInt()))
    }
}

fun funDP(n: Int): Int {
    return if (dp[n] == -1) {
        dp[n] = funDP(n - 1) + funDP(n - 2) + funDP(n - 3)
        dp[n]
    } else {
        dp[n]
    }
}