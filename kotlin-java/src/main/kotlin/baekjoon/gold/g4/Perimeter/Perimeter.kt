package baekjoon.gold.g4.Perimeter

const val n = 102
val map = Array(n) { BooleanArray(n) }
val visited = Array(n) { BooleanArray(n) }
var perimeter = 0

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        map[x][y] = true
    }

    visited[0][0] = true
    dfs(0, 0)
    println(perimeter)
}

fun dfs(x: Int, y: Int) {
    for (i in 0..<4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0..<n || ny !in 0..<n || visited[nx][ny]) continue
        if (map[nx][ny]) {
            perimeter++
            continue
        }

        visited[nx][ny] = true
        dfs(nx, ny)
    }
}
