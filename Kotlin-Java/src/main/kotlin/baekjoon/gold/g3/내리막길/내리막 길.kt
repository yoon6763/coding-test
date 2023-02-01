package baekjoon.gold.g3.내리막길

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

lateinit var map: Array<Array<Int>>
lateinit var dp: Array<Array<Int>>

var n = 0
var m = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nm = br.readLine().split(" ")
    n = nm[0].toInt()
    m = nm[1].toInt()

    map = Array(n) { Array(m) { 0 } }
    dp = Array(n) { Array(m) { -1 } }

    repeat(n) { x ->
        val st = StringTokenizer(br.readLine())
        repeat(m) { y ->
            map[x][y] = st.nextToken().toInt()
        }
    }
    
    println(dfs(0, 0))
}

fun dfs(x: Int, y: Int):Int {
    if(x == n - 1 && y == m - 1 ) return 1
    if(dp[x][y] != -1) return dp[x][y]

    dp[x][y] = 0

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until m || map[x][y] <= map[nx][ny]) continue

        dp[x][y] += dfs(nx, ny)
    }

    return dp[x][y]
}

/*
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
 */