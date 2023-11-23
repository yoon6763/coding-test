package baekjoon.gold.g2

import kotlin.system.exitProcess

lateinit var visited: Array<Array<Boolean>>
lateinit var map: Array<Array<Int>>
lateinit var dp: Array<Array<Int>>

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)
var n = -1
var m = -1
var maxDepth = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { x ->
        val line = readLine()
        Array(m) { y -> if (line[y] == 'H') -1 else line[y].digitToInt() }
    }

    visited = Array(n) { Array(m) { false } }
    visited[0][0] = true
    dp = Array(n) { Array(m) { 0 } }

    dfs(0, 0, 0)

    println(dp[0][0] + 1)
}

fun dfs(x: Int, y: Int, depth: Int) {
    maxDepth = maxOf(depth, maxDepth)

    for (i in 0 until 4) {
        val nx = x + dx[i] * map[x][y]
        val ny = y + dy[i] * map[x][y]

        if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == -1) continue

        if (visited[nx][ny]) {
            println(-1)
            exitProcess(0)
        }

        visited[nx][ny] = true

        if (dp[nx][ny] == 0) dfs(nx, ny, depth + 1)
        dp[x][y] = maxOf(dp[x][y], dp[nx][ny] + 1)

        visited[nx][ny] = false
    }
}