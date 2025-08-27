package baekjoon.silver.s1

fun main() {
    val n = readln().toInt()
    val grid = Array(n) { readln().toCharArray() }
    val visited = Array(n) { BooleanArray(n) }
    var answer = 0

    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    fun dfs(x: Int, y: Int, open: Int, close: Int, closing: Boolean) {
        if (close > open) return
        if (open == close) answer = maxOf(answer, open + close)

        for (i in 0..<4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0..<n || ny !in 0..<n || visited[nx][ny]) continue
            val ch = grid[nx][ny]

            if (closing && ch == '(') continue

            visited[nx][ny] = true
            if (ch == '(') dfs(nx, ny, open + 1, close, false)
            else dfs(nx, ny, open, close + 1, true)
            visited[nx][ny] = false
        }
    }

    if (grid[0][0] == ')') {
        println(0)
        return
    }

    visited[0][0] = true
    dfs(0, 0, 1, 0, false)
    println(answer)
}
