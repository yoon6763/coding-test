package baekjoon.silver.s1.컴백홈

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

var n = 0
var m = 0
var k = 0
var answer = 0

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>

fun main() = with(System.`in`.bufferedReader()) {
    val nmk = readLine().split(" ").map { it.toInt() }
    n = nmk[0]
    m = nmk[1]
    k = nmk[2]

    map = Array(n) { readLine().toCharArray() }
    visited = Array(n) { BooleanArray(m) }

    visited[n - 1][0] = true
    backTracking(n - 1, 0, 0)

    println(answer)
}

fun backTracking(x: Int, y: Int, depth: Int) {
    if (depth == k - 1) {
        if (x == 0 && y == m - 1) {
            answer++
        }
        return
    }

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny] || map[nx][ny] == 'T') continue
        visited[nx][ny] = true
        backTracking(nx, ny, depth + 1)
        visited[nx][ny] = false
    }
}