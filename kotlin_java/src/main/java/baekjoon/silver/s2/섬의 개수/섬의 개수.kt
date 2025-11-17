package baekjoon.silver.s2.`섬의 개수`

val dx = arrayOf(0, 0, 1, -1, 1, -1, 1, -1)
val dy = arrayOf(1, -1, 0, 0, 1, -1, -1, 1)

fun main() = print(generateSequence {
    val (m, n) = readln().split(" ").map { it.toInt() }
    if (n == 0 && m == 0) null else {
        val map = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
        val visited = Array(n) { BooleanArray(m) { false } }
        (0..<n).sumOf { x -> (0..<m).sumOf { y -> dfs(x, y, n, m, map, visited) } }
    }
}.joinToString("\n"))


fun dfs(x: Int, y: Int, n: Int, m: Int, map: Array<IntArray>, visited: Array<BooleanArray>): Int {
    if (x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] == 0) return 0
    visited[x][y] = true
    repeat(8) { dfs(x + dx[it], y + dy[it], n, m, map, visited) }
    return 1
}