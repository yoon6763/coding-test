package baekjoon.silver.s1

import java.util.*

fun main() {
    val n = 8
    val map = Array(n) { Array(n) { 0 } }
    val dx = intArrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
    val dy = intArrayOf(-1, 1, -2, 2, -2, 2, -1, 1)

    val start = readln()
    val sx = start[0] - 'a'
    val sy = start[1] - '1'

    val end = readln()
    val ex = end[0] - 'a'
    val ey = end[1] - '1'

    if(sx == ex && sy == ey) {
        println(0)
        return
    }

    val q = LinkedList<Pair<Int, Int>>() as Queue<Pair<Int, Int>>
    map[sx][sy] = 1
    q.offer(Pair(sx, sy))

    while (q.isNotEmpty()) {
        val target = q.poll()

        for(i in 0 until 8) {
            val nx = target.first + dx[i]
            val ny = target.second + dy[i]

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue
            if(map[nx][ny] != 0) continue

            if(nx == ex && ny == ey) {
                println(map[target.first][target.second])
                return
            }

            map[nx][ny] = map[target.first][target.second] + 1
            q.offer(Pair(nx, ny))
        }
    }
}