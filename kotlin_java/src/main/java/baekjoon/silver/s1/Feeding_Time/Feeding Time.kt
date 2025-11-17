package baekjoon.silver.s1.Feeding_Time

val dx = intArrayOf(0, 1, 0, -1, 1, 1, -1, -1)
val dy = intArrayOf(1, 0, -1, 0, 1, -1, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().toCharArray() }
    val visited = Array(n) { BooleanArray(m) }
    println((0..<n).flatMap { i -> (0..<m).map { j -> dfs(i, j, n, m, map, visited) } }.max())
}

fun dfs(x: Int, y: Int, n: Int, m: Int, map: Array<CharArray>, visited: Array<BooleanArray>): Int {
    if (x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] == '*') return 0
    visited[x][y] = true
    return (0..<8).sumOf { dfs(x + dx[it], y + dy[it], n, m, map, visited) } + 1
}