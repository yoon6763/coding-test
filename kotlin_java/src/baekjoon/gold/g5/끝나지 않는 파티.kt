package baekjoon.gold.g5

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val dp = Array(n) { readLine().split(" ").map { it.toInt() }.toTypedArray() }
    repeat(n) {
        dp[it][it] = 0
    }

    for (k in 0..<n) {
        for (i in 0..<n) {
            for (j in 0..<n) {
                if (dp[i][j] > dp[i][k] + dp[k][j]) {
                    dp[i][j] = dp[i][k] + dp[k][j]
                }
            }
        }
    }

    val sb = StringBuilder()
    repeat(m) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() }
        sb.appendLine(if (dp[from - 1][to - 1] <= cost) "Enjoy other party" else "Stay here")
    }
    print(sb)
}