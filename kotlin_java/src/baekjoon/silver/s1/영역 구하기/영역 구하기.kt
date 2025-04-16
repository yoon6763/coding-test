package baekjoon.silver.s1.`영역 구하기`

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() {
    val (m, n, k) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { BooleanArray(m) }
    repeat(k) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
        for (x in x1..<x2) {
            for (y in y1..<y2) {
                map[x][y] = true
            }
        }
    }

    val ans = mutableListOf<Int>()
    for (i in 0..<n) {
        for (j in 0..<m) {
            val area = dfs(i, j, map, n, m)
            if (area == 0) continue
            ans.add(area)
        }
    }

    println(ans.size)
    println(ans.sorted().joinToString(" "))
}

fun dfs(x: Int, y: Int, map: Array<BooleanArray>, n: Int, m: Int): Int {
    if (x !in 0..<n || y !in 0..<m || map[x][y]) return 0
    map[x][y] = true
    return 1 + (0..3).sumOf { dfs(x + dx[it], y + dy[it], map, n, m) }
}