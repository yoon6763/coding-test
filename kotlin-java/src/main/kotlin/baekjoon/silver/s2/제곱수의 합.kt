package baekjoon.silver.s2

fun main() {
    val n = readln().toInt()
    val dp = IntArray(n + 1) { it }
    for (i in 1..n) {
        for (j in 1..i) {
            if (j * j > i) break
            dp[i] = minOf(dp[i], dp[i - j * j] + 1)
        }
    }
    println(dp[n])
}