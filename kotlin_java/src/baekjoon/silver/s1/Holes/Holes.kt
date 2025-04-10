package baekjoon.silver.s1.`Holes`

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = repeat(readln().toInt()) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().toCharArray() }
    val visited = Array(n) { BooleanArray(m) }
    var space = 0
    var section = 0

    repeat(n) { i ->
        repeat(m) { j ->
            dfs(i, j, n, m, map, visited).let {
                if (it > 0) {
                    space += it
                    section++
                }
            }
        }
    }

    println("$section ${if (section == 1) "section" else "sections"}, $space ${if (space == 1) "space" else "spaces"}")
}

fun dfs(x: Int, y: Int, n: Int, m: Int, map: Array<CharArray>, visited: Array<BooleanArray>): Int {
    if (x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] == '#') return 0
    visited[x][y] = true
    return 1 + (0..<4).sumOf { dfs(x + dx[it], y + dy[it], n, m, map, visited) }
}