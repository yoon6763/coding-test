package baekjoon.silver.s1.영역구하기

import java.util.StringTokenizer

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

lateinit var map: Array<BooleanArray>

var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val mnk = readLine().split(" ").map { it.toInt() }
    n = mnk[1]
    m = mnk[0]

    map = Array(n) { BooleanArray(m) }

    repeat(mnk[2]) {
        val st = StringTokenizer(readLine())
        val (x1, y1, x2, y2) = Array(4) { st.nextToken().toInt() }
        for (x in x1 until x2) {
            for (y in y1 until y2) {
                map[x][y] = true
            }
        }
    }

    var cnt = 0
    val groupCntList = ArrayList<Int>()

    repeat(n) { x ->
        repeat(m) { y ->
            if (!map[x][y]) {
                groupCntList.add(dfs(x, y))
                cnt++
            }
        }
    }
    println(cnt)
    println(groupCntList.sorted().joinToString(" "))
}

fun dfs(x: Int, y: Int): Int {
    var groupCnt = 1
    map[x][y] = true

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until m || map[nx][ny]) continue
        groupCnt += dfs(nx, ny)
    }
    return groupCnt
}