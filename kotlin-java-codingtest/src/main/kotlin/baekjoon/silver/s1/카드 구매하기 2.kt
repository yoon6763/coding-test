package baekjoon.silver.s1

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map(String::toInt).toIntArray()
    val dp = IntArray(n + 1) { 0 }

    for (i in 1..n) {
        for (j in 0 until i) {
            if (dp[i] == 0) dp[i] = dp[i - j - 1] + arr[j]
            else dp[i] = minOf(dp[i], dp[i - j - 1] + arr[j])
        }
    }

    println(dp[n])
}