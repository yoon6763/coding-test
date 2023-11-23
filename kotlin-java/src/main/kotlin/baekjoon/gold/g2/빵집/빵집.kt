package baekjoon.gold.g2.빵집

var r = -1
var c = -1
var cnt = 0
lateinit var map: Array<Array<Char>>
lateinit var visited: Array<Array<Boolean>>

fun main() = with(System.`in`.bufferedReader()) {
    val rc = readLine().split(" ").map { it.toInt() }
    r = rc[0]
    c = rc[1]

    map = Array(r) {
        val line = readLine()
        Array(c) { line[it] }
    }
    visited = Array(r) { Array(c) { false } }

    repeat(r) {
        if (dfs(it, 0)) cnt++
    }

    println(cnt)
}

fun dfs(x: Int, y: Int): Boolean {
    if (y == c - 1) return true

    for (dx in -1..1) {
        val nx = x + dx
        val ny = y + 1

        if (nx !in 0 until r ||
            visited[nx][ny] ||
            map[nx][ny] == 'x'
        ) continue

        visited[nx][ny] = true
        if (dfs(nx, ny)) return true
    }
    return false
}