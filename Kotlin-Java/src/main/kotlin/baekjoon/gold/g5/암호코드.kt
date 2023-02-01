package baekjoon.gold.g5

fun main() {
    val modVal = 1000000
    val input = readln()
    val n = input.length

    if (input[0] == '0') {
        println(0)
        return
    }

    val dp = Array(n + 1) { 0L }
    dp[0] = 1
    dp[1] = 1

    for (i in 2..n) {
        if (input[i - 1].digitToInt() > 0) {
            dp[i] = dp[i - 1] % modVal
        }

        val ten = input[i - 2].digitToInt() * 10 + input[i - 1].digitToInt()

        if (ten in 10..26) {
            dp[i] = (dp[i - 2] + dp[i]) % modVal
        }

    }

    println(dp[n] % modVal)
}