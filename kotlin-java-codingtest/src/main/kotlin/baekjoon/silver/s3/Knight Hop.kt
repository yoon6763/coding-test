package baekjoon.silver.s3

import java.util.*

fun main() {
    val (sx, sy) = readln().split(" ").map { it.toInt() - 1 }
    val (ex, ey) = readln().split(" ").map { it.toInt() - 1 }

    if(sx == ex && sy == ey) {
        println(0)
        return
    }

    val n = 8
    val dx = intArrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
    val dy = intArrayOf(-1, 1, -2, 2, -2, 2, -1, 1)

    val q = LinkedList<Pair<Int, Int>>() as Queue<Pair<Int, Int>>
    val map = Array(n) { Array(n) { 0 } }
    map[sx][sy] = 1
    q.offer(Pair(sx, sy))

    while (q.isNotEmpty()) {
        val target = q.poll()

        for(i in 0 until 8) {
            val nx = target.first + dx[i]
            val ny = target.second + dy[i]

            if(nx !in 0 until 8 || ny !in 0 until 8 || map[nx][ny] != 0) continue
            map[nx][ny] = map[target.first][target.second] + 1

            if(nx == ex && ny == ey) {
                println(map[nx][ny] - 1)
                return
            }

            q.offer(Pair(nx, ny))
        }
    }
}