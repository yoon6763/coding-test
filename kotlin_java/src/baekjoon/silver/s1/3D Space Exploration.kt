package baekjoon.silver.s1

fun main() {
    val n = readln().toInt()
    val map = Array(n) { Array(n) { CharArray(n) } }
    val visited = Array(n) { Array(n) { BooleanArray(n) } }

    for (z in 0 until n) {
        for (y in 0 until n) {
            val line = readln()
            for (x in 0 until n) {
                map[x][y][z] = line[x]
            }
        }
    }

    val dx = intArrayOf(1, -1, 0, 0, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1, 0, 0)
    val dz = intArrayOf(0, 0, 0, 0, 1, -1)

    fun dfs(x: Int, y: Int, z: Int): Boolean {
        if (x !in 0..<n || y !in 0..<n || z !in 0..<n || visited[x][y][z] || map[x][y][z] != '*') return false
        visited[x][y][z] = true
        for (i in 0..<6) dfs(x + dx[i], y + dy[i], z + dz[i])
        return true
    }

    println((0..<n).sumOf { z -> (0..<n).sumOf { y -> (0..<n).count { x -> dfs(x, y, z) } } })
}
