package baekjoon.silver.s3.`사과 빨리 먹기`

lateinit var map: Array<IntArray>
val visited = Array(5) { BooleanArray(5) }
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
var answer = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    map = Array(5) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    val (x, y) = readLine().split(" ").map { it.toInt() }
    visited[x][y] = true
    backTracking(x, y, 0, maxOf(0, map[x][y]))

    println(if (answer == Int.MAX_VALUE) -1 else answer)
}

fun backTracking(x: Int, y: Int, depth: Int, eat: Int) {
    if (eat == 3) {
        answer = minOf(answer, depth)
        return
    }

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until 5 || ny !in 0 until 5 || visited[nx][ny] || map[nx][ny] == -1) continue
        visited[nx][ny] = true
        backTracking(nx, ny, depth + 1, eat + maxOf(0, map[nx][ny]))
        visited[nx][ny] = false
    }
}