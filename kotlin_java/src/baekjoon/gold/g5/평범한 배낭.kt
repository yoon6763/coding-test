package baekjoon.gold.g5

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val arr = Array(n + 1) { IntArray(2) }
    for (i in 1..n) {
        val (weight, value) = readLine().split(" ").map { it.toInt() }
        arr[i][0] = weight
        arr[i][1] = value
    }

    val dp = Array(n + 1) { IntArray(k + 1) }

    for (i in 1..n) {
        for (j in 1..k) {
            if (j - arr[i][0] >= 0) {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - arr[i][0]] + arr[i][1])
            } else {
                dp[i][j] = dp[i - 1][j]
            }
        }
    }

    println(dp[n][k])
}