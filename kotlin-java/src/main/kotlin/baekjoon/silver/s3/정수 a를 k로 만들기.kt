package baekjoon.silver.s3

fun main() {
    val (start, end) = readln().split(" ").map { it.toInt() }
    val dp = IntArray(end + 1) { 987654321 }
    dp[start] = 1

    for (i in 1..<end) {
        if (dp[i] == 987654321) continue

        dp[i + 1] = minOf(dp[i + 1], dp[i] + 1)

        val double = i * 2
        if (double <= end) {
            dp[double] = minOf(dp[double], dp[i] + 1)
        }
    }

    println(dp[end] - 1)
}