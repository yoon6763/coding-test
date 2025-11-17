package baekjoon.silver.s1.Islands

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { readLine().toCharArray() }
    visited = Array(n) { BooleanArray(m) }

    var answer = 0

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (visited[i][j] || map[i][j] != 'L') continue
            answer++
            dfs(i, j)
        }
    }

    println(answer)
}

fun dfs(x: Int, y: Int) {
    visited[x][y] = true
    for (i in 0..<4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] || map[nx][ny] == 'W') continue
        dfs(nx, ny)
    }
}