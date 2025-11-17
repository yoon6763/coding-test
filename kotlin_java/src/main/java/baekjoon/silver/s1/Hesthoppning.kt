package baekjoon.silver.s1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().toCharArray() }

    val dx = intArrayOf(1, 1, -1, -1, 2, 2, -2, -2)
    val dy = intArrayOf(2, -2, 2, -2, 1, -1, 1, -1)

    val visited = Array(n) { BooleanArray(m) }

    val horsePoints = buildList {
        for (i in 0 until n)
            for (j in 0 until m)
                if (map[i][j] == 'H') {
                    add(Pair(i, j))
                    map[i][j] = '.'
                }
    }

    fun dfs(x: Int, y: Int) {
        if (x !in 0 until n || y !in 0 until m || visited[x][y] || map[x][y] == '#') return
        visited[x][y] = true
        for (i in dx.indices) dfs(x + dx[i], y + dy[i])
    }

    dfs(horsePoints[0].first, horsePoints[0].second)
    println(if (visited[horsePoints[1].first][horsePoints[1].second]) "JA" else "NEJ")
}