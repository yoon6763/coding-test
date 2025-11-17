package baekjoon.gold.g3.`거울 설치`

data class Light(val x: Int, val y: Int, val dir: Int)

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, -1, 0, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val pos = ArrayList<Light>()
    val map = Array(n) { x ->
        val line = readLine().toCharArray()
        for (y in line.indices) {
            if (line[y] == '#') {
                pos.add(Light(x, y, 0))
            }
        }
        line
    }

    val start = pos[0]
    val end = pos[1]

    val visited = Array(n) { Array(n) { Array(4) { 0 } } }
    val q = ArrayDeque<Light>()

    for (i in 0..<4) {
        q.add(Light(start.x, start.y, i))
        visited[start.x][start.y][i] = 1
    }

    while (q.isNotEmpty()) {
        val (x, y, d) = q.removeFirst()

        for (i in 1..50) {
            val nx = x + dx[d] * i
            val ny = y + dy[d] * i

            if (nx !in 0..<n || ny !in 0..<n || map[nx][ny] == '*') break

            if (nx == end.x && ny == end.y) {
                println(visited[x][y][d] - 1)
                return
            }

            if (map[nx][ny] == '!') {
                for (dx in intArrayOf(-1, 1)) {
                    var nd = d + dx
                    if (nd == -1) nd = 3
                    if (nd == 4) nd = 0

                    if (visited[nx][ny][nd] != 0) continue
                    visited[nx][ny][nd] = visited[x][y][d] + 1
                    q.add(Light(nx, ny, nd))
                }
            }
        }
    }
}