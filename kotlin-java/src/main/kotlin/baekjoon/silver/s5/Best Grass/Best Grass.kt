package baekjoon.silver.s5.`Best Grass`

data class Node(val x: Int, val y: Int)

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]
    map = Array(n) { readLine().toCharArray() }
    visited = Array(n) { BooleanArray(m) }

    var answer = 0
    repeat(n) { x ->
        repeat(m) { y ->
            if (map[x][y] == '#' && !visited[x][y]) {
                visited[x][y] = true
                dfs(x, y)
                answer++
            }
        }
    }

    println(answer)
}

fun dfs(x: Int, y: Int): Boolean {
    for (i in 0..<4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] == '.' || visited[nx][ny]) continue
        visited[nx][ny] = true
        if (dfs(nx, ny)) return true
    }

    return false
}