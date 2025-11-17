package baekjoon.silver.s1.`점프왕쩰리 (Large)`

import java.util.StringTokenizer
import kotlin.system.exitProcess

var n = 0
lateinit var visited: Array<Array<Boolean>>
lateinit var map: Array<Array<Int>>

fun main() {
    val br = System.`in`.bufferedReader()

    n = br.readLine().toInt()
    map = Array(n) { Array(n) { 0 } }
    visited = Array(n) { Array(n) { false } }

    // 값 세팅
    repeat(n) { x ->
        val st = StringTokenizer(br.readLine())
        repeat(n) { y ->
            map[x][y] = st.nextToken().toInt()
        }
    }

    visited[0][0] = true
    dfs(0, 0)

    println("Hing")
}

fun dfs(x: Int, y: Int) {
    // 목표점 도살 시 프로그램 종료
    if (x == n - 1 && y == n - 1) {
        println("HaruHaru")
        exitProcess(0)
    }

    // 현재 위치 + 현재 칸 숫자
    val nx = arrayOf(x, x + map[x][y])
    val ny = arrayOf(y + map[x][y], y)

    for (i in 0 until 2) {
        if (nx[i] !in 0 until n || ny[i] !in 0 until n || visited[nx[i]][ny[i]]) continue
        visited[nx[i]][ny[i]] = true
        dfs(nx[i], ny[i])
    }
}