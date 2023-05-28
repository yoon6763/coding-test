package baekjoon.silver.s3

fun main() {
    val n = readLine()!!.toInt()
    val dp = Array<Long>(n + 1) { it.toLong() }

    if (n <= 2) {
        println(n)
        return
    }

    for (i in 3..n) dp[i] = (dp[i - 1] + dp[i - 2]) % 10007

    println(dp[n])
}