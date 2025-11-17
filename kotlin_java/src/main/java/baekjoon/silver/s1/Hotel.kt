package baekjoon.silver.s1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().toCharArray() }
    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(-1, 1, 0, 0)

    fun dfs(x: Int, y: Int): Int {
        if (x !in 0..<n || y !in 0..<m || map[x][y] == '*') return 0
        map[x][y] = '*'
        return 1 + (0..3).sumOf { i -> dfs(x + dx[i], y + dy[i]) }
    }

    val ans = (0..<n).maxOf { i -> (0..<m).maxOf { j -> dfs(i, j) } }
    println(if (ans == 0) -1 else ans)
}