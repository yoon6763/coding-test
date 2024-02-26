package baekjoon.silver.s2.`유기농 배추`

import java.io.BufferedReader
import java.io.InputStreamReader

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)
lateinit var map: Array<Array<Int>>
var n = 0
var m = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val T = br.readLine().toInt()

    repeat(T) {
        val mnk = br.readLine().split(" ")
        m = mnk[0].toInt()
        n = mnk[1].toInt()
        val k = mnk[2].toInt()
        var cnt = 0

        map = Array(n) { Array(m) { 0 } }

        repeat(k) { k ->
            val xy = br.readLine().split(" ")
            map[xy[1].toInt()][xy[0].toInt()] = 1
        }

        repeat(n) { x ->
            repeat(m) { y ->
                if(dfs(x,y)) cnt++
            }
        }

        println(cnt)
    }
}

fun dfs(x: Int, y: Int): Boolean {
    if (map[x][y] == 0) return false

    map[x][y] = 0
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == 0)
            continue
        dfs(nx, ny)
    }
    return true
}


/*
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5
 */