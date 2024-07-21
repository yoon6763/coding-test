package baekjoon.silver.s2.`A-maze-ing Lakes`

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
var n = 0
var m = 0
var dx = intArrayOf(0, 0, 1, -1)
var dy = intArrayOf(1, -1, 0, 0)
var depth = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { readLine().toCharArray() }
    visited = Array(n) { BooleanArray(m) }
    val answer = mutableListOf<Int>()
    var result = 0

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (map[i][j] != '1' || visited[i][j]) continue
            result++
            depth = 0
            dfs(i, j)
            answer.add(depth)
        }
    }

    println(result)
    println(answer.sorted().joinToString("\n"))
}

fun dfs(x: Int, y: Int) {
    visited[x][y] = true
    depth += 1

    for (i in 0..<4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] == '0' || visited[nx][ny]) continue
        dfs(nx, ny)
    }
}