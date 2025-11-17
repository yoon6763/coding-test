package baekjoon.gold.g4.알파벳

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val map = Array(r) { readln().toCharArray().map { it - 'A' }.toIntArray() }
    val visited = BooleanArray(26)
    visited[map[0][0]] = true
    println(dfs(0, 0, 1, r, c, map, visited))
}

fun dfs(x: Int, y: Int, depth: Int, r: Int, c: Int, map: Array<IntArray>, visited: BooleanArray): Int {
    var maxDepth = depth

    for (i in 0..<4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0..<r || ny !in 0..<c || visited[map[nx][ny]]) continue

        visited[map[nx][ny]] = true
        maxDepth = maxOf(maxDepth, dfs(nx, ny, depth + 1, r, c, map, visited))
        visited[map[nx][ny]] = false
    }

    return maxDepth
}