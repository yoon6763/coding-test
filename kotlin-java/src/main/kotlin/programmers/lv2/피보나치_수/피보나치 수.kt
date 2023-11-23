package programmers.lv2.피보나치_수

fun solution(n: Int): Int {
    val dp = Array(n+1) { 0 }
    dp[1] = 1

    for(i in 2 .. n) {
        dp[i] = (dp[i-1] + dp[i-2]) % 1234567
    }

    return dp[n]
}