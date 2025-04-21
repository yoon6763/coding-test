package baekjoon.silver.s2.`Bad Grass`

val dx = intArrayOf(1, -1, 0, 0, 1, 1, -1, -1)
val dy = intArrayOf(0, 0, 1, -1, 1, -1, 1, -1)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    print((0..<n).sumOf { i -> (0..<m).count { j -> dfs(i, j, n, m, map) } })
}

fun dfs(x: Int, y: Int, n: Int, m: Int, map: Array<IntArray>): Boolean {
    if (x !in 0..<n || y !in 0..<m || map[x][y] == 0) return false
    map[x][y] = 0
    for (i in 0..<8) dfs(x + dx[i], y + dy[i], n, m, map)
    return true
}