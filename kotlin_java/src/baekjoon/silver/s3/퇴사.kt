package baekjoon.silver.s3

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    // 1일에 잡힌 상담 -> arr[0]일, arr[1]원
    val arr = Array(n) { readLine().split(" ").map { it.toInt() } }
    val dp = Array(n + 1) { 0 }

    for (i in 0 until n) {
        if (i + arr[i][0] <= n) {
            if (i > 0) dp[i] = maxOf(dp[i], dp[i - 1])
            dp[i + arr[i][0]] = maxOf(dp[i + arr[i][0]], dp[i] + arr[i][1])
        }
    }

    println(dp.contentToString())
    println(dp.maxOrNull()!!)
}