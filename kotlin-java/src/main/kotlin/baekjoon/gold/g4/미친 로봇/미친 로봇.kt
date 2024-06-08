package baekjoon.gold.g4.`미친 로봇`

import java.util.*

val visited = Array(29) { Array(29) { false } }
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)
val percent = DoubleArray(4)
var n = 0
var ans = 0.0

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())

    n = st.nextToken().toInt()
    repeat(4) {
        percent[it] = st.nextToken().toDouble() / 100
    }
    visited[14][14] = true

    dfs(14, 14, 0, 1.0)
    println(ans)
}

fun dfs(x: Int, y: Int, depth: Int, p: Double) {
    if (depth == n) {
        ans += p
        return
    }

    for (i in 0..<4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (visited[nx][ny]) continue
        visited[nx][ny] = true
        dfs(nx, ny, depth + 1, p * percent[i])
        visited[nx][ny] = false
    }
}