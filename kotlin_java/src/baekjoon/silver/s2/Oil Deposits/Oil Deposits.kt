package baekjoon.silver.s2.`Oil Deposits`

data class Node(val x: Int, val y: Int)

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(-1, 1, 0, 0, -1, -1, 1, 1)
val dy = intArrayOf(0, 0, -1, 1, -1, 1, -1, 1)
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while (true) {
        val nm = readLine().split(" ").map { it.toInt() }
        if (nm[0] == 0 && nm[1] == 0) break
        n = nm[0]
        m = nm[1]

        map = Array(n) { readLine().toCharArray() }
        visited = Array(n) { BooleanArray(m) }

        var cnt = 0

        for (i in 0..<n) {
            for (j in 0..<m) {
                if (!visited[i][j] && map[i][j] == '@') {
                    dfs(i, j)
                    cnt++
                }
            }
        }

        sb.appendLine(cnt)
    }

    print(sb)
}

fun dfs(x: Int, y: Int) {
    visited[x][y] = true

    for (i in 0..<8) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] || map[nx][ny] == '*') continue
        dfs(nx, ny)
    }
}