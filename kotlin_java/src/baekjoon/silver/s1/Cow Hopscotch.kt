package baekjoon.silver.s1

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().split(" ").map { it.toInt() } }
    val dp = Array(n) { IntArray(m) { -1 } }

    fun dfs(x: Int, y: Int): Int {
        if (x == n - 1 && y == m - 1) return 1
        if (dp[x][y] != -1) return dp[x][y]

        var count = 0
        for (nx in x + 1..<n) {
            for (ny in y + 1..<m) {
                if (map[nx][ny] == map[x][y]) continue
                count = (count + dfs(nx, ny)) % 1_000_000_007
            }
        }
        dp[x][y] = count
        return count
    }

    println(dfs(0, 0))
}
