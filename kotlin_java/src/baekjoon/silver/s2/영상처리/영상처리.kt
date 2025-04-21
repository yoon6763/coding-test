package baekjoon.silver.s2.영상처리

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val originMap = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(n) { BooleanArray(m) }
    val standard = readln().toInt()

    val map =
        Array(n) { i -> IntArray(m) { j -> if ((originMap[i][j * 3] + originMap[i][j * 3 + 1] + originMap[i][j * 3 + 2]) / 3 >= standard) 1 else 0 } }

    println((0..<n).sumOf { i ->
        (0..<m).count { j ->
            if (map[i][j] == 1 && !visited[i][j]) {
                visited[i][j] = true
                dfs(i, j, n, m, map, visited)
                true
            } else {
                false
            }
        }
    })
}

fun dfs(x: Int, y: Int, n: Int, m: Int, map: Array<IntArray>, visited: Array<BooleanArray>) {
    for (i in 0..<4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] || map[nx][ny] == 0) continue
        visited[nx][ny] = true
        dfs(nx, ny, n, m, map, visited)
    }
}