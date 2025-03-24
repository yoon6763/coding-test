package baekjoon.gold.g3.`일루미네이션`

import java.util.*

data class Node(val x: Int, val y: Int)

lateinit var map: Array<IntArray>
lateinit var visited: Array<IntArray>

val dx1 = intArrayOf(0, 1, 1, 0, -1, -1)
val dy1 = intArrayOf(-1, 0, 1, 1, 1, 0)

val dx2 = intArrayOf(1, 1, 0, -1, -1, 0)
val dy2 = intArrayOf(-1, 0, 1, 0, -1, -1)

var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val mn = readLine().split(' ').map { it.toInt() }
    n = mn[1]
    m = mn[0]
    map = Array(n + 2) { IntArray(m + 2) }

    for (i in 1..n) {
        val st = StringTokenizer(readLine())
        for (j in 1..m) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    visited = Array(n + 2) { IntArray(m + 2) }

    dfs(0, 0)

    var answer = 0
    for (i in 0..<n + 2) {
        for (j in 0..<m + 2) {
            if (map[i][j] == 1) answer += visited[i][j]
        }
    }

    println(answer)
}

fun dfs(x: Int, y: Int) {
    val dx = if (x % 2 != 0) dx1 else dx2
    val dy = if (x % 2 != 0) dy1 else dy2

    for (i in 0..<6) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0..<n + 2 || ny !in 0..<m + 2) continue
        if (map[nx][ny] == 1) {
            visited[nx][ny]++
            continue
        }

        if (visited[nx][ny] != 0) continue
        visited[nx][ny] = 1
        dfs(nx, ny)
    }
}