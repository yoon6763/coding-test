package baekjoon.silver.s2

val dp = Array(21) { Array(21) { IntArray(21) } }

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while (true) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        if (a == -1 && b == -1 && c == -1) break
        sb.append("w($a, $b, $c) = ").appendLine(w(a, b, c))
    }

    print(sb)
}

fun w(a: Int, b: Int, c: Int): Int {
    if (a in 0..20 && b in 0..20 && c in 0..20 && dp[a][b][c] != 0) return dp[a][b][c]
    if (a <= 0 || b <= 0 || c <= 0) return 1
    if (a > 20 || b > 20 || c > 20) return w(20, 20, 20).also { dp[20][20][20] = it }
    if (a < b && b < c) return (w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)).also { dp[a][b][c] = it }
    return (w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)).also { dp[a][b][c] = it }
}