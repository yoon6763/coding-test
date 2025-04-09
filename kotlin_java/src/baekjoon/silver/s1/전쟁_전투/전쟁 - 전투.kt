package baekjoon.silver.s1.전쟁_전투

import kotlin.math.pow

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val ans = mutableMapOf<Char, Double>()
    val map = Array(n) { readln().toCharArray() }
    val visited = Array(n) { BooleanArray(m) }
    repeat(n) { i -> repeat(m) { j -> ans[map[i][j]] = (ans[map[i][j]] ?: 0.0) + dfs(i, j, n, m, map[i][j], map, visited).pow(2.0) } }
    println("${ans['W']?.toInt()} ${ans['B']?.toInt()}")
}

fun dfs(x: Int, y: Int, n: Int, m: Int, team: Char, map: Array<CharArray>, visited: Array<BooleanArray>): Double {
    if (x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] != team) return 0.0
    visited[x][y] = true
    return 1 + (0..<4).sumOf { dfs(x + dx[it], y + dy[it], n, m, team, map, visited) }
}