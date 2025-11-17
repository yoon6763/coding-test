package baekjoon.silver.s3.`세 번 이내에 사과를 먹자`

lateinit var map: Array<IntArray>
val visited = Array(5) { BooleanArray(5) }
var apple = 0
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    map = Array(5) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val (x, y) = readLine().split(" ").map { it.toInt() }
    visited[x][y] = true
    dfs(x, y, 0, 0)
    println(if (apple >= 2) 1 else 0)
}

fun dfs(x: Int, y: Int, depth: Int, nowApple: Int) {
    apple = maxOf(apple, nowApple)
    if (depth == 3) return

    for (i in 0..<4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx !in 0..<5 || ny !in 0..<5 || map[nx][ny] == -1 || visited[nx][ny]) continue
        visited[nx][ny] = true
        dfs(nx, ny, depth + 1, nowApple + maxOf(0, map[nx][ny]))
        visited[nx][ny] = false
    }
}