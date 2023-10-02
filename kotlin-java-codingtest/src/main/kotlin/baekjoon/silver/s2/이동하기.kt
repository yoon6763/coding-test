package baekjoon.silver.s2

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().split(" ").map { it.toLong() } }
    val dp = Array(n) { Array(m) { 0L } }
    dp[0][0] = map[0][0]

    val dx = arrayOf(1, 0, 1)
    val dy = arrayOf(0, 1, 1)

    for (x in 0 until n) {
        for (y in 0 until m) {
            for (i in 0 until 3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx in 0 until n && ny in 0 until m) dp[nx][ny] = maxOf(dp[nx][ny], map[nx][ny] + dp[x][y])
            }
        }
    }
    println(dp[n - 1][m - 1])
}