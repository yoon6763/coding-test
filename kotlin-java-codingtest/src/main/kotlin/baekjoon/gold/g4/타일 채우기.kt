package baekjoon.gold.g4

fun main() {
    val n = readln().toInt()
    if (n % 2 == 1) {
        println(0)
        return
    }

    val dp = Array(n + 1) { 0 }
    dp[0] = 1

    for (i in 2..n step 2) {
        dp[i] = dp[i - 2] * 3
        for (j in 4..i step 2) {
            dp[i] += dp[i - j] * 2
        }
    }

    println(dp[n])
}