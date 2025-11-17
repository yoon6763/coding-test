package baekjoon.gold.g1

fun main() {
    val MOD = 1000000000
    val n = readln().toInt()
    val dp = Array(n + 1) { Array(10) { Array(1 shl 10) { 0 } } }

    for (i in 1..9) {
        dp[1][i][1 shl i] = 1
    }

    for (i in 2..n) {
        for (j in 0..9) {
            for (k in 0 until (1 shl 10)) {
                val visited = k or (1 shl j)

                when (j) {
                    0 -> dp[i][j][visited] += dp[i - 1][j + 1][k]
                    9 -> dp[i][j][visited] += dp[i - 1][j - 1][k]
                    else -> dp[i][j][visited] += dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]
                }

                dp[i][j][visited] %= MOD
            }
        }
    }

    var answer = 0L
    for (i in 0..9) {
        answer += dp[n][i][(1 shl 10) - 1]
    }

    println(answer % MOD)
}