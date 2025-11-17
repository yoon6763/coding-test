package baekjoon.silver.s4

fun main() = with(System.`in`.bufferedReader()) {
    val n = 10
    val map = Array(n) { readLine().toCharArray() }

    var start = 0 to 0
    var end = 0 to 0

    repeat(n) { x ->
        repeat(n) { y ->
            if (map[x][y] == 'B') end = x to y
            if (map[x][y] == 'L') start = x to y
        }
    }

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    val visited = Array(n) { IntArray(n) }
    val q = ArrayDeque<Pair<Int, Int>>()
    q.add(start)
    visited[start.first][start.second] = 1

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (i in 0 until 4) {
            val nx = cur.first + dx[i]
            val ny = cur.second + dy[i]

            if (nx !in 0 until n || ny !in 0 until n || visited[nx][ny] != 0 || map[nx][ny] == 'R') continue
            if (nx == end.first && ny == end.second) {
                println(visited[cur.first][cur.second] - 1)
                return
            }

            visited[nx][ny] = visited[cur.first][cur.second] + 1
            q.add(nx to ny)
        }
    }
}