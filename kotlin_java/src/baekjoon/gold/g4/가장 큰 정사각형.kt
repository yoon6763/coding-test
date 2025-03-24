package baekjoon.gold.g4

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val arr = Array(n) { readLine().toCharArray().map { it - '0' }.toIntArray() }
    val dp = Array(n) { IntArray(m) { 0 } }

    for(i in 0 until n) dp[i][0] = arr[i][0]
    for(i in 0 until m) dp[0][i] = arr[0][i]

    for (i in 1 until n) {
        for (j in 1 until m) {
            if (arr[i][j] == 0) continue
            dp[i][j] = minOf(dp[i - 1][j], minOf(dp[i][j - 1], dp[i - 1][j - 1])) + arr[i][j]
        }
    }

    val len = dp.map { it.maxOf { it } }.maxOf { it }.toLong()
    println(len * len)
}