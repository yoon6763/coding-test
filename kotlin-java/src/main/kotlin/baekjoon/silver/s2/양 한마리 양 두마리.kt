package baekjoon.silver.s2

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val (n,m) = readLine().split(" ").map { it.toInt() }
        val map = Array(n) { readLine().toCharArray() }
        var sheep = 0

        for(x in 0 until n) {
            for(y in 0 until m) {
                if(map[x][y] == '.') continue
                sheep++

                val q = LinkedList<Pair<Int, Int>>() as Queue<Pair<Int, Int>>
                q.offer(Pair(x, y))
                map[x][y] = '.'

                while (q.isNotEmpty()) {
                    val target = q.poll()

                    for(i in 0 until 4) {
                        val nx = target.first + dx[i]
                        val ny = target.second + dy[i]

                        if(nx !in 0 until n || ny !in 0 until m || map[nx][ny] == '.') continue
                        q.offer(Pair(nx, ny))
                        map[nx][ny] = '.'
                    }
                }
            }
        }

        sb.append("$sheep\n")
    }

    print(sb)
}