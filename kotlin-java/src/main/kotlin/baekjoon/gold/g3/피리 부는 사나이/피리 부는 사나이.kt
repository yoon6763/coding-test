package baekjoon.gold.g3.`피리 부는 사나이`

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var map: Array<Array<Char>>
lateinit var visited: Array<Array<Boolean>>
lateinit var group: Array<Array<Boolean>>

var groupCnt = 0
var n = 0
var m = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    n = nm[0].toInt()
    m = nm[1].toInt()

    visited = Array(n) { Array(m) { false } }
    group = Array(n) { Array(m) { false } }
    map = Array(n) { Array(m) { ' ' } }

    repeat(n) { x ->
        val line = br.readLine()
        repeat(m) { y ->
            map[x][y] = line[y]
        }
    }

    repeat(n) { x ->
        repeat(m) { y ->
            if (!visited[x][y]) dfs(x, y)
        }
    }

    print(groupCnt)
}

fun dfs(x: Int, y: Int) {
    visited[x][y] = true

    val direction = map[x][y]

    val dx = when (direction) {
        'R', 'L' -> 0
        'U' -> -1
        'D' -> 1
        else -> 0
    }
    val dy = when (direction) {
        'D', 'U' -> 0
        'R' -> 1
        'L' -> -1
        else -> 0
    }

    // 지도 나가는 방향으로 방향이 주어지지 않기 때문에 n, m 범위 내인지 체크 불필요
    val nx = x + dx
    val ny = y + dy

    if(!visited[nx][ny]) {
        dfs(nx,ny)
    } else {
        if(!group[nx][ny]) groupCnt++
    }
    group[x][y] = true
}

/*
3 4
DLLL
DRLU
RRRU
 */