package baekjoon.silver.s1

import java.util.StringTokenizer

fun main() = repeat(readln().toInt()) {
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    val st = StringTokenizer(readln())
    val (m, n) = List(2) { st.nextToken().toInt() }
    var (y1, x1, y2, x2) = List(4) { st.nextToken().toInt() - 1 }
    val map = Array(n) { readln().toCharArray() }

    x1 = n - 1 - x1
    x2 = n - 1 - x2

    val visited = Array(n) { BooleanArray(m) }

    fun dfs(x: Int, y: Int, type: Char): Boolean {
        if (x == x2 && y == y2) return true
        if (x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] != type) return false
        visited[x][y] = true
        return (0..<4).any { dfs(x + dx[it], y + dy[it], type) }
    }

    println(if (dfs(x1, y1, map[x1][y1])) "YES" else "NO")
}