package baekjoon.silver.s1.`유턴 싫어`

import kotlin.system.exitProcess

var n = 0
var m = 0
lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { readLine().toCharArray() }
    visited = Array(n) { BooleanArray(m) }

    visited[0][0] = true
    dfs(0, 0, -1, -1)
    println("0")
}

fun dfs(x: Int, y: Int, preX: Int, preY: Int) {
    var cnt = 0

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == 'X') continue
        if (nx == preX && ny == preY) continue
        if (visited[nx][ny]) continue
        visited[nx][ny] = true
        dfs(nx, ny, x, y)
        cnt++
    }

    if (cnt == 0) {
        println("1")
        exitProcess(0)
    }
}