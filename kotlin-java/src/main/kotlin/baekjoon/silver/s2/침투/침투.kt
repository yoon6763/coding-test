package baekjoon.silver.s2.침투

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)
lateinit var map: Array<CharArray>

var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { readLine().toCharArray() }

    for (i in 0 until m) {
        if (map[0][i] == '0') {
            map[0][i] = '1'

            if (dfs(0, i)) {
                println("YES")
                return
            }
        }
    }
    println("NO")
}

fun dfs(x: Int, y: Int): Boolean {
    if (x == n - 1) return true

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == '1') continue
        map[nx][ny] = '1'
        if (dfs(nx, ny)) return true
    }

    return false
}