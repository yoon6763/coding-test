package goormlevel.lv2.`피보나치 수`

fun main() {
    val n = readLine()!!.toInt()
    if (n == 1) {
        println(0)
        return
    }

    val dp = Array(n + 1) { 0L }
    dp[2] = 1

    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007
    }
    println(dp[n])
}