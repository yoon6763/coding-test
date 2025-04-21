package baekjoon.silver.s2.`Oil Deposits`

val dx = intArrayOf(-1, 1, 0, 0, -1, -1, 1, 1)
val dy = intArrayOf(0, 0, -1, 1, -1, 1, -1, 1)

fun main() = generateSequence { readln().split(" ").map { it.toInt() }.takeIf { it.any { it != 0 } } }.forEach { (n, m) ->
    val map = Array(n) { readln().toCharArray() }
    val visited = Array(n) { BooleanArray(m) }
    println((0..<n).sumOf { i -> (0..<m).count { j -> dfs(i, j, n, m, map, visited) } })
}

fun dfs(x: Int, y: Int, n: Int, m: Int, map: Array<CharArray>, visited: Array<BooleanArray>): Boolean {
    if (x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] == '*') return false
    visited[x][y] = true
    for (i in 0..<8) dfs(x + dx[i], y + dy[i], n, m, map, visited)
    return true
}