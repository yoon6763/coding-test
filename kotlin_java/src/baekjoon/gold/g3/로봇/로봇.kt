package baekjoon.gold.g3.`로봇`

import java.util.ArrayDeque
import java.util.StringTokenizer

data class Robot(val x: Int, val y: Int, val dir: Int)

// 남 서 북 동
val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, -1, 0, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    var st: StringTokenizer
    val map = Array(n) {
        st = StringTokenizer(readLine())
        IntArray(m) { st.nextToken().toInt() }
    }

    st = StringTokenizer(readLine())
    val start = Robot(st.nextToken().toInt() - 1, st.nextToken().toInt() - 1, st.nextToken().toInt().toMyDir())
    st = StringTokenizer(readLine())
    val end = Robot(st.nextToken().toInt() - 1, st.nextToken().toInt() - 1, st.nextToken().toInt().toMyDir())

    if (start == end) {
        println(0)
        return@with
    }

    val visited = Array(n) { Array(m) { IntArray(4) } }
    val q = ArrayDeque<Robot>()
    q.add(start)
    visited[start.x][start.y][start.dir] = 1

    while (q.isNotEmpty()) {
        val cur = q.poll()
        val (x, y, d) = cur

        if (cur == end) {
            println(visited[x][y][d] - 1)
            return@with
        }

        for (deltaDir in intArrayOf(-1, 1)) {
            var nd = d + deltaDir
            if (nd == -1) nd = 3
            if (nd == 4) nd = 0
            if (visited[x][y][nd] != 0) continue
            visited[x][y][nd] = visited[x][y][d] + 1
            q.offer(Robot(x, y, nd))
        }

        for (distance in 1..3) {
            val nx = x + dx[d] * distance
            val ny = y + dy[d] * distance
            if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] == 1) break
            if (visited[nx][ny][d] != 0) continue
            visited[nx][ny][d] = visited[x][y][d] + 1
            q.offer(Robot(nx, ny, d))
        }
    }
}

// 입력 : 동쪽 1, 서쪽 2, 남쪽 3, 북쪽 4
fun Int.toMyDir() = when (this) {
    1 -> 3
    2 -> 1
    3 -> 0
    else -> 2
}