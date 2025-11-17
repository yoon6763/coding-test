package programmers.lv2.멀리_뛰기

fun solution(n: Int): Long {
    val dp = LongArray(n + 1)
    if (n == 1) return 1

    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567
    }

    return dp[n]
}