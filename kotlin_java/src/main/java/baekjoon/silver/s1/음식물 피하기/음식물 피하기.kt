package baekjoon.silver.s1.`음식물 피하기`

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }

    val map = Array(n) { BooleanArray(m) }
    repeat(k) {
        val (x, y) = readln().split(" ").map { it.toInt() - 1 }
        map[x][y] = true
    }

    println((0..<n).maxOf { x -> (0..<m).maxOf { y -> dfs(x, y, n, m, map) } })
}

fun dfs(x: Int, y: Int, n: Int, m: Int, map: Array<BooleanArray>): Int {
    if (x !in 0..<n || y !in 0..<m || !map[x][y]) return 0
    map[x][y] = false
    return 1 + (0..<4).sumOf { dfs(x + dx[it], y + dy[it], n, m, map) }
}