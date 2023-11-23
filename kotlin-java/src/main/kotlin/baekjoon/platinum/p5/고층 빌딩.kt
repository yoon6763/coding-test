package baekjoon.platinum.p5

fun main() = with(System.`in`.bufferedReader()) {
    val mod = 1000000007L
    val (n, l, r) = readLine().split(" ").map { it.toInt() }

    val dp = Array(101) { Array(101) { Array(101) { 0L } } }
    dp[1][1][1] = 1

    for (i in 2..n) {
        for (j in 1..l) {
            for (k in 1..r) {
                dp[i][j][k] = (dp[i - 1][j][k] * (i - 2) + (dp[i - 1][j][k - 1] + dp[i - 1][j - 1][k])) % mod
            }
        }
    }

    println(dp[n][l][r])
}