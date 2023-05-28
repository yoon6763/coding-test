package baekjoon.silver.s2.헌내기는친구가필요해

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

lateinit var map: Array<Array<Int>>
lateinit var visited: Array<Array<Boolean>>
var n = 0
var m = 0
var cnt = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { Array(m) { 0 } }
    visited = Array(n) { Array(m) { false } }

    var startX = 0
    var startY = 0

    repeat(n) { x ->
        val line = readLine()
        repeat(m) { y ->
            map[x][y] = when (line[y]) {
                'O' -> 0
                'I' -> {
                    startX = x
                    startY = y
                    1
                }

                'P' -> 2
                else -> -1
            }
        }
    }

    visited[startX][startY] = true
    dfs(startX, startY)
    println(if (cnt == 0) "TT" else cnt)
}

fun dfs(x: Int, y: Int) {
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny] || map[nx][ny] == -1) continue

        // P
        if (map[nx][ny] == 2) {
            cnt++
        }
        visited[nx][ny] = true
        dfs(nx, ny)
    }
}