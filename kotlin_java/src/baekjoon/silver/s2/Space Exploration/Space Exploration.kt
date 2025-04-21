package baekjoon.silver.s2.`Space Exploration`

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    val n = readln().toInt()
    val map = Array(n) { readln().toCharArray() }
    print((0..<n).sumOf { i -> (0..<n).count { j -> dfs(i, j, n, map) } })
}

fun dfs(x: Int, y: Int, n: Int, map: Array<CharArray>): Boolean {
    if (x !in 0..<n || y !in 0..<n || map[x][y] == '.') return false
    map[x][y] = '.'
    for (i in 0..<4) dfs(x + dx[i], y + dy[i], n, map)
    return true
}