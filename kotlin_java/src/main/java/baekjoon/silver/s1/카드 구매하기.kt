package baekjoon.silver.s1

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map(String::toInt).toIntArray()
    val dp = IntArray(n + 1)

    for (i in 1..n) {
        for (j in 0 until n) {
            if (i - j - 1 < 0) break
            dp[i] = maxOf(dp[i], dp[i - j - 1] + arr[j])
        }
    }

    println(dp[n])
}