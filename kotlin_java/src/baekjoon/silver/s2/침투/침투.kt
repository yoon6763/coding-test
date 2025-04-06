package baekjoon.silver.s2.침투

val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(1, 0, -1, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().toCharArray() }
    val visited = Array(n) { BooleanArray(m) }
    println(if ((0..<m).any { dfs(0, it, n, m, map, visited) }) "YES" else "NO")
}

fun dfs(x: Int, y: Int, n: Int, m: Int, map: Array<CharArray>, visited: Array<BooleanArray>): Boolean =
    when {
        x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] == '1' -> false
        x == n - 1 -> true
        else -> {
            visited[x][y] = true
            (0..<4).any { dfs(x + dx[it], y + dy[it], n, m, map, visited) }
        }
    }