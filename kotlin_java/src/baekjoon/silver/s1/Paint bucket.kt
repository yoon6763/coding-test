package baekjoon.silver.s1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().map { it.digitToInt() }.toIntArray() }
    val visited = Array(n) { BooleanArray(m) }
    val (x, y, k) = readln().split(" ").map { it.toInt() }

    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(-1, 1, 0, 0)

    fun dfs(x: Int, y: Int, origin: Int, target: Int) {
        if (x !in 0..<n || y !in 0..<m || map[x][y] != origin || visited[x][y]) return
        map[x][y] = target
        visited[x][y] = true
        repeat(4) { dfs(x + dx[it], y + dy[it], origin, target) }
    }

    dfs(x, y, map[x][y], k)
    println(map.joinToString("\n") { it.joinToString("") })
}