package baekjoon.silver.s1

fun main() {
    val n = readln().toInt()
    val dp = Array(n + 1) { LongArray(10) }
    repeat(10) { dp[1][it] = 1 }

    for (i in 2..n) {
        for (j in 0..9) {
            for (k in 0..j) {
                dp[i][j] += dp[i - 1][k]
            }
            dp[i][j] = dp[i][j] % 10007
        }
    }

    println(dp[n].sum() % 10007)
}