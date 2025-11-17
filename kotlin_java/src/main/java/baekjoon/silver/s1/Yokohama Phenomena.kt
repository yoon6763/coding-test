package baekjoon.silver.s1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val str = "YOKOHAMA"
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    val map = Array(n) { readln().toCharArray() }
    val dp = Array(n) { Array(m) { IntArray(str.length) { -1 } } }

    fun dfs(x: Int, y: Int, depth: Int): Int {
        if (depth == str.length - 1) return 1
        if (dp[x][y][depth] != -1) return dp[x][y][depth]

        var res = 0

        for (i in 0..<4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] != str[depth + 1]) continue
            res += dfs(nx, ny, depth + 1)
        }

        dp[x][y][depth] = res
        return res
    }

    var ans = 0
    for (i in 0..<n) {
        for (j in 0..<m) {
            if (map[i][j] != 'Y') continue
            ans += dfs(i, j, 0)
        }
    }

    println(ans)
}
