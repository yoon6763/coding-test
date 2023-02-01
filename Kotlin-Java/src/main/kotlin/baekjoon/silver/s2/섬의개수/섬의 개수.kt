package baekjoon.silver.s2.섬의개수

import java.util.*

val dx = arrayOf(0, 0, 1, -1, 1, -1, 1, -1)
val dy = arrayOf(1, -1, 0, 0, 1, -1, -1, 1)

var cnt = 0
var n = 0
var m = 0

lateinit var map: Array<Array<Int>>
lateinit var visited: Array<Array<Boolean>>

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while (true) {
        cnt = 0

        val nm = readLine().split(" ").map { it.toInt() }
        n = nm[1]
        m = nm[0]

        if (n == 0 && m == 0) break

        map = Array(n) { Array(m) { 0 } }
        visited = Array(n) { Array(m) { false } }

        repeat(n) { x ->
            val st = StringTokenizer(readLine())
            repeat(m) { y ->
                map[x][y] = st.nextToken().toInt()
            }
        }

        repeat(n) { x ->
            repeat(m) { y ->
                if (map[x][y] == 1 && !visited[x][y]) {
                    dfs(x, y)
                    cnt++
                }
            }
        }

        sb.append("$cnt\n")
    }

    print(sb)
}


fun dfs(x: Int, y: Int) {
    visited[x][y] = true

    for (i in 0 until 8) {
        val nx = dx[i] + x
        val ny = dy[i] + y

        if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 0) continue

        visited[nx][ny] = true
        dfs(nx, ny)
    }
}