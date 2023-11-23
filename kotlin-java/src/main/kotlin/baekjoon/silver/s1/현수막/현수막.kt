package baekjoon.silver.s1.현수막

lateinit var map: Array<Array<Int>>
var n = 0
var m = 0
val dx = intArrayOf(0, 0, 1, -1, 1, 1, -1, -1)
val dy = intArrayOf(1, -1, 0, 0, 1, -1, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    var cnt = 0

    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]
    map = Array(n) { readLine().split(" ").map { it.toInt() }.toTypedArray() }
    repeat(n) { x ->
        repeat(m) { y ->
            if (map[x][y] == 1) {
                dfs(x, y)
                cnt++
            }
        }
    }
    println(cnt)
}

fun dfs(x: Int, y: Int) {
    for (i in 0 until 8) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == 0) continue
        map[nx][ny] = 0
        dfs(nx, ny)
    }
}