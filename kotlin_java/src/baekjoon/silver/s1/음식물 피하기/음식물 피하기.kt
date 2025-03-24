package baekjoon.silver.s1.`음식물 피하기`

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

var n = 0
var m = 0

lateinit var map: Array<BooleanArray>

fun main() = with(System.`in`.bufferedReader()) {
    val nmk = readLine().split(" ").map { it.toInt() }
    n = nmk[0]
    m = nmk[1]
    map = Array(n) { BooleanArray(m) }

    repeat(nmk[2]) {
        val (x, y) = readLine().split(" ").map { it.toInt() - 1 }
        map[x][y] = true
    }

    var max = 0
    repeat(n) { x ->
        repeat(m) { y ->
            if (map[x][y]) max = maxOf(max, dfs(x, y))
        }
    }
    println(max)
}

fun dfs(x: Int, y: Int): Int {
    map[x][y] = false
    var cnt = 1

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx !in 0 until n || ny !in 0 until m || !map[nx][ny]) continue

        cnt += dfs(nx, ny)
    }
    return cnt
}