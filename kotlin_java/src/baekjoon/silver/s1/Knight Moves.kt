package baekjoon.silver.s1

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val n = 8
    val dx = intArrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
    val dy = intArrayOf(-1, 1, -2, 2, -2, 2, -1, 1)

    while (true) {
        val line = readLine()
        if (line == null || line == "") break

        val sx = line[0] - 'a'
        val sy = line[1] - '1'

        val ex = line[3] - 'a'
        val ey = line[4] - '1'

        if(sx == ex && sy == ey) {
            sb.append("To get from ${line[0]}${line[1]} to ${line[3]}${line[4]} takes 0 knight moves.").append("\n")
            continue
        }

        val q = LinkedList<Pair<Int, Int>>() as Queue<Pair<Int, Int>>
        val map = Array(n) { Array(n) { 0 } }

        q.offer(Pair(sx, sy))
        map[sx][sy] = 1

        while (q.isNotEmpty()) {
            val target = q.poll()

            for(i in 0 until 8) {
                val nx = target.first + dx[i]
                val ny = target.second + dy[i]

                if(nx !in 0 until n || ny !in 0 until n || map[nx][ny] != 0) continue
                map[nx][ny] = map[target.first][target.second] + 1

                if(nx == ex && ny == ey) {
                    sb.append("To get from ${line[0]}${line[1]} to ${line[3]}${line[4]} takes ${map[nx][ny] - 1} knight moves.").append("\n")
                    break
                }

                q.offer(Pair(nx, ny))
            }
        }
    }

    print(sb)
}