package baekjoon.silver.s4

fun main() {
    val n = readln().toInt()
    val arr = DoubleArray(n) { readln().toDouble() }
    val dp = DoubleArray(n)
    dp[0] = arr[0]
    for (i in 1..<n) dp[i] = maxOf(arr[i], dp[i - 1] * arr[i])

    println("%.3f".format(dp.maxOrNull()))
}