package baekjoon.gold.g2._1의_개수_세기

lateinit var dp: LongArray

fun main() = with(System.`in`.bufferedReader()) {
    val (a, b) = readLine().trim().split(" ").map { it.toLong() }

    dp = LongArray(55)
    dp[0] = 1
    for (i in 1 until 55) {
        dp[i] = (dp[i - 1] shl 1) + (1L shl i)
    }

    println(solve(b) - solve(a - 1))
}

fun solve(n: Long): Long {
    var n = n
    var ans = n and 1

    for (i in 54 downTo 1) {
        if ((n and (1L shl i)) > 0L) {
            ans += dp[i - 1] + (n - (1L shl i) + 1)
            n -= (1L shl i)
        }
    }
    return ans
}
