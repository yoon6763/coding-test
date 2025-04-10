package baekjoon.silver.s1.단지번호붙이기

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    val n = readln().toInt()
    val map = Array(n) { readln().toCharArray() }
    val ans = mutableListOf<Int>()

    repeat(n) { x ->
        repeat(n) { y ->
            val area = dfs(x, y, n, map)
            if (area > 0) ans.add(area)
        }
    }

    println("${ans.size}\n${ans.sorted().joinToString("\n")}")
}

fun dfs(x: Int, y: Int, n: Int, map: Array<CharArray>): Int {
    if (x !in 0..<n || y !in 0..<n || map[x][y] == '0') return 0
    map[x][y] = '0'
    return 1 + (0..<4).sumOf { dfs(x + dx[it], y + dy[it], n, map) }
}