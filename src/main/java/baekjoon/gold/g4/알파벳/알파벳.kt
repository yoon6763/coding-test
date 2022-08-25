package baekjoon.gold.g4.알파벳

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var map: Array<Array<Int>>
val visited = Array(26) { false }
val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)
var r = -1
var c = -1
var maxDepth = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val rc = br.readLine().split(" ")
    r = rc[0].toInt()
    c = rc[1].toInt()

    map = Array(r) { Array(c) { -1 } }
    repeat(r) { x ->
        val line = br.readLine()
        repeat(c) { y ->
            map[x][y] = line[y] - 'A'
        }
    }

    visited[map[0][0]] = true
    dfs(0, 0, 1)

    println(maxDepth)
}


fun dfs(x: Int, y: Int, depth: Int) {
    if (maxDepth < depth) maxDepth = depth

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until r || ny !in 0 until c || visited[map[nx][ny]]) continue

        visited[map[nx][ny]] = true
        dfs(nx, ny, depth + 1)
        visited[map[nx][ny]] = false
    }
}