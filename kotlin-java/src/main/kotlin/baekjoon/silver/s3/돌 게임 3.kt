package baekjoon.silver.s3

fun main() {
    val n = readln().toInt()
    val dp = IntArray(1001)
    dp[1] = 1
    dp[2] = 0
    dp[3] = 1
    dp[4] = 1
    dp[5] = 1

    for (i in 6..n) {
        dp[i] = 0
        listOf(1, 3, 4).forEach {
            if (dp[i - it] == 0) dp[i] = 1
        }
    }

    println(if (dp[n] == 1) "SK" else "CY")
}