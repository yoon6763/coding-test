package baekjoon.gold.g5.테트로미노

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


lateinit var visited: Array<Array<Boolean>>
lateinit var map: Array<Array<Int>>

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

var n = 0
var m = 0
var maxSum = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")

    n = nm[0].toInt()
    m = nm[1].toInt()

    map = Array(n) { Array(m) { 0 } }
    visited = Array(n) { Array(m) { false } }

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine(), " ")
        for (j in 0 until m)
            map[i][j] = st.nextToken().toInt()
    }


    repeat(n) { x ->
        repeat(m) { y ->

            woo(x, y)

            visited[x][y] = true
            dfs(x, y, 0, map[x][y])
            visited[x][y] = false
        }
    }

    println(maxSum)

}

fun dfs(x: Int, y: Int, times: Int, argsSum: Int) {

    if (times >= 3) {
        if (maxSum < argsSum) {
            maxSum = argsSum
        }
        return
    }

    for (i in 0 until 4) {
        val nx = dx[i] + x
        val ny = dy[i] + y

        if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny])
            continue

        visited[nx][ny] = true
        dfs(nx, ny, times + 1, argsSum + map[nx][ny])
        visited[nx][ny] = false
    }
}

// ㅜ 모양 검색
fun woo(x: Int, y: Int) {
    if ((x == 0 && y == 0) || (x == n - 1 && y == m - 1) || (x == 0 && y == m - 1) || (x == n - 1 && y == 0))
        return

    var etcSum = 0

    if (x == 0) {
        etcSum = map[x][y] + map[x + 1][y] + map[x][y + 1] + map[x][y - 1]
    } else if (x == n) {
        etcSum = map[x][y] + map[x - 1][y] + map[x][y + 1] + map[x][y - 1]
    } else if (y == 0) {
        etcSum = map[x][y] + map[x][y + 1] + map[x + 1][y] + map[x - 1][y]
    } else if (y == m) {
        etcSum = map[x][y] + map[x][y - 1] + map[x + 1][y] + map[x - 1][y]
    } else {
        if (x !in 1 until n - 1 || y !in 1 until m - 1) {
            return
        }

        for (i in 0 until 4) {
            etcSum =
                map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y - 1] + map[x][y + 1] - map[x + dx[i]][y + dy[i]]
            if (maxSum < etcSum) maxSum = etcSum
        }
        return
    }

    if (maxSum < etcSum) maxSum = etcSum
}