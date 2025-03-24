package baekjoon.silver.s1.`Holes`

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
var n = 0
var m = 0
var space = 0
var section = 0

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val nm = readLine().split(" ").map { it.toInt() }
        n = nm[0]
        m = nm[1]

        map = Array(n) { readLine().toCharArray() }
        visited = Array(n) { BooleanArray(m) }

        space = 0
        section = 0

        for (i in 0..<n) {
            for (j in 0..<m) {
                if (!visited[i][j] && map[i][j] == '.') {
                    section++
                    dfs(i, j)
                }
            }
        }

        sb.appendLine("$section ${if (section == 1) "section" else "sections"}, $space ${if (space == 1) "space" else "spaces"}")
    }

    print(sb)
}

fun dfs(x: Int, y: Int) {
    visited[x][y] = true
    space++

    for (i in 0..<4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] || map[nx][ny] == '#') continue
        dfs(nx, ny)
    }
}