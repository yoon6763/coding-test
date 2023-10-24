package baekjoon.gold.g5

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map(String::toInt)
    val arr = Array(n + 1) { Array(2) { 0 } } // 0 - 무게, 1 - 가치

    for (i in 1 until n) {
        val (w, v) = readLine().split(" ").map(String::toInt)
        arr[i][0] = w
        arr[i][1] = v
    }

    val dp = Array(n + 1) { Array(k + 1) { 0 } }

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