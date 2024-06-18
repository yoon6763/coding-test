package baekjoon.gold.g5.`농장 관리`

import java.util.*

lateinit var map: Array<IntArray>
lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(1, -1, 0, 0, 1, -1, 1, -1)
val dy = intArrayOf(0, 0, 1, -1, 1, -1, -1, 1)
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) {
        val st = StringTokenizer(readLine())
        IntArray(m) { st.nextToken().toInt() }
    }

    visited = Array(n) { BooleanArray(m) }

    val k = map.maxOf { it.maxOrNull()!! }
    var ans = 0

    for (height in k downTo 1) {
        for (i in 0..<n) {
            for (j in 0..<m) {
                if (map[i][j] == height && !visited[i][j]) {
                    ans++
                    dfs(i, j, height)
                }
            }
        }
    }

    println(ans)
}

fun dfs(x: Int, y: Int, height: Int) {
    visited[x][y] = true

    for (i in 0..<8) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] > height || visited[nx][ny]) continue
        dfs(nx, ny, map[nx][ny])
    }
}