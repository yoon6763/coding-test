package baekjoon.silver.s2.IslandExploration

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().toCharArray() }
    val visited = Array(n) { BooleanArray(m) }
    val (x, y) = map.indices.flatMap { i -> map[i].indices.map { j -> i to j } }.first { map[it.first][it.second] == 'S' }
    println(dfs(x, y, map, visited, n, m))
}

fun dfs(x: Int, y: Int, map: Array<CharArray>, visited: Array<BooleanArray>, n: Int, m: Int): Int {
    if (x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] == '.') return 0
    visited[x][y] = true
    return 1 + (0..3).sumOf { dfs(x + dx[it], y + dy[it], map, visited, n, m) }
}