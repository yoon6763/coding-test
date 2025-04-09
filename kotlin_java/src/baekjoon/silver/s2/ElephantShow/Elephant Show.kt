package baekjoon.silver.s2.ElephantShow

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    while (true) {
        val (m, n) = readln().split(" ").map { it.toInt() }
        val map = Array(n) { readln().toCharArray() }
        if (n == 0 && m == 0) break
        val (sx, sy) = (0..<n).flatMap { x -> (0..<m).map { y -> Pair(x, y) } }.first { map[it.first][it.second] == 'A' }
        println(dfs(sx, sy, n, m, map, Array(n) { BooleanArray(m) }))
    }
}

fun dfs(x: Int, y: Int, n: Int, m: Int, map: Array<CharArray>, visited: Array<BooleanArray>): Int {
    if (x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] == '#') return 0
    visited[x][y] = true
    return 1 + (0..<4).sumOf { dfs(x + dx[it], y + dy[it], n, m, map, visited) }
}