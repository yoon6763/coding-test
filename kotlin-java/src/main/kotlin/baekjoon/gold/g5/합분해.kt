package baekjoon.gold.g5

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val dp = Array(k + 1) { IntArray(n + 1) }
    dp[1].fill(1)

    for (depth in 2..k) {
        for (i in 0..n) {
            for (j in 0..i) {
                dp[depth][i] = (dp[depth - 1][i - j] + dp[depth][i]) % 1000000000
            }
        }
    }

    println(dp[k][n])
}