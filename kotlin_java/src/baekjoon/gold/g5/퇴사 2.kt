package baekjoon.gold.g5

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { readLine().split(" ").map { it.toInt() } }
    val dp = IntArray(n + 1)

    for (i in 0..<n) {
        if (i > 0) dp[i] = maxOf(dp[i], dp[i - 1])
        val afterDay = i + arr[i][0]
        if (afterDay <= n) dp[afterDay] = maxOf(dp[afterDay], dp[i] + arr[i][1])
    }
    println(dp.maxOrNull())
}