package baekjoon.silver.s2.`Satellite Photographs`

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().toCharArray() }
    println((0..<n).maxOf { i -> (0..<m).maxOf { j -> dfs(i, j, n, m, arr) } })
}

fun dfs(x: Int, y: Int, n: Int, m: Int, arr: Array<CharArray>): Int {
    if (x !in 0..<n || y !in 0..<m || arr[x][y] == '.') return 0
    arr[x][y] = '.'
    return 1 + (0..<4).sumOf { dfs(x + dx[it], y + dy[it], n, m, arr) }
}
