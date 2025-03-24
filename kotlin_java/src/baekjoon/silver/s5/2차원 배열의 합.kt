package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    val dp = Array(n + 1) { IntArray(m + 1) }

    for (i in 1..n) {
        for (j in 1..m) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i - 1][j - 1]
        }
    }

    repeat(readLine().toInt()) {
        val (i, j, x, y) = readLine().split(" ").map { it.toInt() }
        println(dp[x][y] - dp[i - 1][y] - dp[x][j - 1] + dp[i - 1][j - 1])
    }
}