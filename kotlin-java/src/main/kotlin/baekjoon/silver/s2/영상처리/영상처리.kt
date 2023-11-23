package baekjoon.silver.s2.영상처리

lateinit var visited: Array<BooleanArray>
lateinit var map: Array<IntArray>
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    val originMap = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    visited = Array(n) { BooleanArray(m) }
    val standard = readLine().toInt()

    map = Array(n) { IntArray(m) }

    repeat(n) { i ->
        repeat(m) { j ->
            map[i][j] =
                if ((originMap[i][j * 3] + originMap[i][j * 3 + 1] + originMap[i][j * 3 + 2]) / 3 >= standard) 1 else 0
        }
    }

    var cnt = 0

    repeat(n) { i ->
        repeat(m) { j ->
            if (map[i][j] == 1 && !visited[i][j]) {
                visited[i][j] = true
                dfs(i, j)
                cnt++
            }
        }
    }

    println(cnt)
}

fun dfs(x: Int, y: Int) {
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny] || map[nx][ny] == 0) continue
        visited[nx][ny] = true
        dfs(nx, ny)
    }
}