package baekjoon.silver.s2.침투

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
var flag = false
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    visited = Array(n) { BooleanArray(m) }
    map = Array(n) { readLine().toCharArray() }

    for (i in 0..<m) {
        if (dfs(0, i)) {
            println("YES")
            return
        }
    }
    println("NO")
}

fun dfs(x: Int, y: Int): Boolean {
    for (i in 0..<4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] || map[nx][ny] == '1') continue
        if (nx == n - 1) return true
        visited[nx][ny] = true
        if (dfs(nx, ny)) return true
    }

    return false
}
