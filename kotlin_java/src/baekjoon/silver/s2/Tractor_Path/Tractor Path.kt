package baekjoon.silver.s2.Tractor_Path

import kotlin.system.exitProcess

lateinit var arr: Array<CharArray>
lateinit var visited: Array<BooleanArray>
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = Array(n) { readLine().toCharArray() }
    visited = Array(n) { BooleanArray(n) }
    dfs(0, 0)
    println("No")
}

fun dfs(x: Int, y: Int) {
    if (x >= n || y >= n || arr[x][y] == 'x' || visited[x][y]) return
    if (x == n - 1 && y == n - 1) {
        println("Yes")
        exitProcess(0)
    }
    visited[x][y] = true
    dfs(x + 1, y)
    dfs(x, y + 1)
}