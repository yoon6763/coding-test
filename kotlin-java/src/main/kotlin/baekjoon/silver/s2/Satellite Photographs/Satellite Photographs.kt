package baekjoon.silver.s2.`Satellite Photographs`

lateinit var arr: Array<String>
lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
var n = 0
var m = 0
var mapSize = 0

fun main() = with(System.`in`.bufferedReader()) {
    val mn = readLine().split(" ").map { it.toInt() }
    m = mn[0]
    n = mn[1]
    arr = Array(n) { readLine() }
    visited = Array(n) { BooleanArray(m) }

    var answer = 0

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (visited[i][j] || arr[i][j] == '.') continue
            mapSize = 0
            dfs(i, j)
            answer = maxOf(answer, mapSize)
        }
    }

    println(answer)
}

fun dfs(x: Int, y: Int) {
    visited[x][y] = true
    mapSize++

    for (i in 0..<4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(nx !in 0 until n || ny !in 0 until m || arr[nx][ny] == '.' || visited[nx][ny]) continue
        dfs(nx, ny)
    }
}
