package baekjoon.gold.g3.`욕심쟁이 판다`

import java.util.*
import kotlin.math.max

lateinit var map: Array<Array<Int>>
lateinit var dp: Array<Array<Int>>
val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)
var n = 0
var max = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    map = Array(n) { Array(n) { 0 } }
    dp = Array(n) { Array(n) { 0 } }

    repeat(n) { x ->
        val st = StringTokenizer(readLine())
        repeat(n) { y ->
            map[x][y] = st.nextToken().toInt()
        }
    }

    var max = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            dfs(i, j)
            max = max(max, dp[i][j])
        }
    }
    println(max)
}


fun dfs(x: Int, y: Int): Int {

    if (dp[x][y] != 0) return dp[x][y]

    dp[x][y] = 1

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until n || map[nx][ny] <= map[x][y]) {
            continue
        }

        dp[x][y] = max(dfs(nx, ny) + 1, dp[x][y])
    }

    return dp[x][y]
}