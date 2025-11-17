package baekjoon.silver.s1

fun main() {
    val n = readln().toInt()
    val map = Array(n) { readln().split(" ").map { it.toInt() } }
    val dp = Array(n) { Array(n) { 0L } }

    dp[0][0] = 1

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (dp[i][j] == 0L || map[i][j] == 0) continue

            val distance = map[i][j]

            val ni = i + distance
            val nj = j + distance

            if (ni in 0 until n) dp[ni][j] += dp[i][j]
            if (nj in 0 until n) dp[i][nj] += dp[i][j]
        }
    }

    println(dp[n - 1][n - 1])
}