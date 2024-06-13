package goormlevel.lv3.`보드 게임`

fun main() {
    val n = readLine()!!.toInt()
    val dp = LongArray(n + 1)
    dp[1] = 1
    dp[2] = 1
    dp[3] = 2

    for (i in 4..n) {
        dp[i] += (dp[i - 1] + dp[i - 3]) % 1000000007
    }

    println(dp[n])
}