package baekjoon.silver.s2

fun main() = with(System.`in`.bufferedReader()) {

    val sharkPointList = ArrayList<Pair<Int, Int>>()

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val line = readLine().split(" ").map { it.toInt() }

        for (j in 0 until m) {
            map[i][j] = line[j]
            if (line[j] == 1) sharkPointList.add(Pair(i, j))
        }
    }

    val dx = intArrayOf(-1, 1, 0, 0, 1, 1, -1, -1)
    val dy = intArrayOf(0, 0, -1, 1, 1, -1, 1, -1)

    var maxSafeDistance = 0
    val visited = Array(n) { IntArray(m) { -1 } }
    val q = ArrayList<Pair<Int, Int>>()

    sharkPointList.forEach { sharkPoint ->
        val (sx, sy) = sharkPoint
        q.add(Pair(sx, sy))
        visited[sx][sy] = 0
    }

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (i in 0 until 8) {
            val nx = cur.first + dx[i]
            val ny = cur.second + dy[i]

            if (nx !in 0 until n ||
                ny !in 0 until m ||
                map[nx][ny] == 1 ||
                visited[nx][ny] != -1
            ) continue
            visited[nx][ny] = visited[cur.first][cur.second] + 1
            q.add(Pair(nx, ny))
        }
    }

    println(visited.maxOf { it.maxOrNull()!! })
}