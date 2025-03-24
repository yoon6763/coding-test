package baekjoon.gold.g1.비숍

lateinit var visited: Array<BooleanArray>
lateinit var chess: Array<IntArray>
var dy = intArrayOf(-1, -1, 1, 1)
var dx = intArrayOf(-1, 1, 1, -1)
var cnt = intArrayOf(0, 0)
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    chess = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    visited = Array(n) { BooleanArray(n) }

    backTracking(0, 0, 0, 0)
    backTracking(0, 1, 0, 1)

    println(cnt[0] + cnt[1])
}

fun backTracking(oldX: Int, oldY: Int, depth: Int, color: Int) {
    var x = oldX
    var y = oldY
    cnt[color] = depth.coerceAtLeast(cnt[color])

    if (y >= n) {
        x += 1
        y = if (color == 0) {
            if (x % 2 == 0) 0 else 1
        } else {
            if (x % 2 == 0) 1 else 0
        }
    }
    if (x >= n) return

    if (check(x, y)) {
        visited[x][y] = true
        backTracking(x, y + 2, depth + 1, color)
        visited[x][y] = false
    }

    backTracking(x, y + 2, depth, color)
}

fun check(x: Int, y: Int): Boolean {
    if (chess[x][y] == 0) return false

    for (i in 0 until 4) {
        for (j in 0 until n) {
            val nx = x + dx[i] * j
            val ny = y + dy[i] * j
            if (nx !in 0 until n || ny !in 0 until n) break
            if (visited[nx][ny]) return false
        }
    }
    return true
}