package baekjoon.silver.s2.`RAINFOREST CANOPY`

var n = 0
lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>

val dx = intArrayOf(-1, 1, 0, 0, -1, -1, 1, 1)
val dy = intArrayOf(0, 0, -1, 1, -1, 1, -1, 1)

fun main()  {
    var idx = 1

    while (true) {
        try {
            val line = readlnOrNull() ?: break
            n = line.trim().toInt()

        } catch (e: Exception) {
            break
        }
        map = Array(n) { readln().trim().toCharArray() }
        visited = Array(n) { BooleanArray(n) }

        var count = 0
        for (i in 0..<n) {
            for (j in 0..<n) {
                if (visited[i][j] || map[i][j] == '0') continue
                dfs(i, j)
                count++
            }
        }

        println("Case #${idx++}: $count")
    }
}

fun dfs(x: Int, y: Int) {
    visited[x][y] = true

    for (i in 0..<8) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx !in 0..<n || ny !in 0..<n || visited[nx][ny] || map[nx][ny] == '0') continue
        dfs(nx, ny)
    }
}