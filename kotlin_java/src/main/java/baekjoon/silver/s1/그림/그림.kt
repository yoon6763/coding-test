package baekjoon.silver.s1.그림

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = List(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    var (cnt, max) = 0 to 0
    repeat(n) { x ->
        repeat(m) { y ->
            val area = dfs(x, y, n, m, map)
            if (area > 0) {
                cnt++
                max = maxOf(max, area)
            }
        }
    }
    println("$cnt\n$max")
}

fun dfs(x: Int, y: Int, n: Int, m: Int, map: List<IntArray>): Int {
    if (x !in 0..<n || y !in 0..<m || map[x][y] == 0) return 0
    map[x][y] = 0
    return 1 + (0..<4).sumOf { dfs(x + dx[it], y + dy[it], n, m, map) }
}