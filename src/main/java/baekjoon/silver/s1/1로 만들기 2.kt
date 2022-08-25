package baekjoon.silver.s1

fun main() {
    val n = readLine()!!.toInt()

    val dp = Array(n + 1) { 0 }
    dp[1] = 0
    val old = Array(n + 1) { -1 }
    old[1] = -1

    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1
        old[i] = i - 1

        if (i % 2 == 0) {
            if (dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1
                old[i] = i / 2
            }
        }
        if (i % 3 == 0) {
            if (dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1
                old[i] = i / 3
            }
        }
    }

    println(dp[n])

    val sb = StringBuilder()
    var idx = n
    sb.append(n).append(" ")

    while (old[idx] != -1) {
        sb.append(old[idx]).append(" ")
        idx = old[idx]
    }

    print(sb)
}