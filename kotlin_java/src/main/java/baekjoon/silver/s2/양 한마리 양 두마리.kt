package baekjoon.silver.s2

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() = repeat(readln().toInt()) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().toCharArray() }
    val visited = Array(n) { BooleanArray(m) }
    println((0..<n).sumOf { x -> (0..<m).sumOf { y -> dfs(x, y, n, m, map, visited) } })
}

fun dfs(x: Int, y: Int, n: Int, m: Int, map: Array<CharArray>, visited: Array<BooleanArray>): Int {
    if (x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] == '.') return 0
    visited[x][y] = true
    repeat(4) { dfs(x + dx[it], y + dy[it], n, m, map, visited) }
    return 1
}