package baekjoon.gold.g2.Maaaaaaaaaze

lateinit var map: Array<Array<IntArray>>
val dx = intArrayOf(0, 0, 0, 0, 1, -1)
val dy = intArrayOf(0, 0, 1, -1, 0, 0)
val dz = intArrayOf(1, -1, 0, 0, 0, 0)
var min = Int.MAX_VALUE
const val n = 5

fun main() = with(System.`in`.bufferedReader()) {
    map = Array(n) { Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() } }
    backTracking(0)
    println(if (min == Int.MAX_VALUE) -1 else min)
}

fun backTracking(depth: Int) {
    if (depth == 5) {
        if (map[0][0][0] == 0 || map[4][4][4] == 0) return
        min = minOf(min, bfs())
        return
    }

    for (i in 0..4) {
        rotate(depth)
        backTracking(depth + 1)
    }
}

fun bfs(): Int {
    val visited = Array(n) { Array(n) { IntArray(n) } }
    val queue = ArrayDeque<Triple<Int, Int, Int>>()

    queue.addFirst(Triple(0, 0, 0))
    visited[0][0][0] = 1

    while (queue.isNotEmpty()) {
        val target = queue.removeLast()

        for (i in 0 until 6) {
            val nx = target.first + dx[i]
            val ny = target.second + dy[i]
            val nz = target.third + dz[i]

            if (nx !in 0 until n || ny !in 0 until n || nz !in 0 until n ||
                map[nx][ny][nz] == 0 || visited[nx][ny][nz] != 0
            ) continue

            if (nx == 4 && ny == 4 && nz == 4) return visited[target.first][target.second][target.third]

            visited[nx][ny][nz] = visited[target.first][target.second][target.third] + 1
            queue.addFirst(Triple(nx, ny, nz))
        }
    }

    return Int.MAX_VALUE
}

private fun rotate(idx: Int) {
    val temp = Array(n) { IntArray(n) }
    for (y in 0 until n) {
        for (x in 0 until n) {
            temp[y][x] = map[idx][n - x - 1][y]
        }
    }
    System.arraycopy(temp, 0, map[idx], 0, temp.size)
}