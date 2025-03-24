package baekjoon.silver.s2.ShebasAmoebas

val dx = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
val dy = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>

var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { readLine().toCharArray() }
    visited = Array(n) { BooleanArray(m) }

    println((0..<n).sumOf { i -> (0..<m).count { j -> dfs(i, j) } })
}

fun dfs(x: Int, y: Int): Boolean {
    if (x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] == '.') return false

    visited[x][y] = true

    for (i in 0..<8) {
        dfs(x + dx[i], y + dy[i])
    }

    return true
}