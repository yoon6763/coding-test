package baekjoon.silver.s1.`안전 영역`

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    val n = readln().toInt()
    val map = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    var ans = 1

    for (h in 1..100) {
        val visited = Array(n) { BooleanArray(n) }
        ans = maxOf(ans, (0..<n).sumOf { x -> (0..<n).sumOf { y -> dfs(x, y, n, h, map, visited) } })
    }

    println(ans)
}

fun dfs(x: Int, y: Int, n: Int, waterHeight: Int, map: Array<IntArray>, visited: Array<BooleanArray>): Int {
    if (x !in 0..<n || y !in 0..<n || visited[x][y] || map[x][y] <= waterHeight) return 0
    visited[x][y] = true
    repeat(4) { dfs(x + dx[it], y + dy[it], n, waterHeight, map, visited) }
    return 1
}