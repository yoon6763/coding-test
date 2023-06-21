package baekjoon.gold.g4.빙산

import java.util.StringTokenizer

var n = 0
var m = 0

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)

lateinit var visited: Array<Array<Boolean>>
lateinit var map: Array<Array<Int>>
var iceGroupCnt = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) {
        val st = StringTokenizer(readLine())
        Array(m) { st.nextToken().toInt() }
    }

    var year = 0

    while (true) {
        year++
        melt()
        visited = Array(n) { Array(m) { false } }
        iceGroupCnt = 0

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (dfs(i, j)) iceGroupCnt++
                if (iceGroupCnt >= 2) {
                    println(year)
                    return
                }
            }
        }

        if (iceGroupCnt == 0) {
            println(0)
            return
        }
    }
}

fun dfs(x: Int, y: Int): Boolean {
    if (map[x][y] == 0 || visited[x][y]) return false
    visited[x][y] = true

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny] || map[nx][ny] == 0) continue
        dfs(nx, ny)
    }

    return true
}

fun melt() {
    val meltMap = Array(n) { Array(m) { 0 } }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 0) continue

            for (k in 0 until 4) {
                val nx = i + dx[k]
                val ny = j + dy[k]

                if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] != 0) continue
                meltMap[i][j]++
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            map[i][j] -= meltMap[i][j]
            if (map[i][j] < 0) map[i][j] = 0
        }
    }
}