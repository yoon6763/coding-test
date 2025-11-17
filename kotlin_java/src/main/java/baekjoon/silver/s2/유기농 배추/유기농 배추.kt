package baekjoon.silver.s2.`유기농 배추`

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() = repeat(readln().toInt()) {
    val (m, n, k) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }.apply {
        repeat(k) { readln().split(" ").map { it.toInt() }.let { this[it[1]][it[0]] = 1 } }
    }

    println((0..<n).sumOf { x -> (0..<m).count { y -> dfs(x, y, n, m, map) } })
}

fun dfs(x: Int, y: Int, n: Int, m: Int, map: Array<IntArray>): Boolean {
    if (x !in 0..<n || y !in 0..<m || map[x][y] == 0) return false
    map[x][y] = 0
    for (i in 0..<4) dfs(x + dx[i], y + dy[i], n, m, map)
    return true
}