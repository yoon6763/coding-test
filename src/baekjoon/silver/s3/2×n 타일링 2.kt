package baekjoon.silver.s3

fun main() {
    val n = readLine()!!.toInt()
    val dp = Array<Long>(n + 1) { 0 }

    when (n) {
        1 -> {
            println(1)
            return
        }
        2 -> {
            println(3)
            return
        }
    }

    dp[1] = 1
    dp[2] = 3
    dp[3] = 5

    for (i in 3..n) dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007
    println(dp[n])
}