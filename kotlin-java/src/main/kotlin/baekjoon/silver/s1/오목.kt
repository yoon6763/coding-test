package baekjoon.silver.s1

import java.util.*
import kotlin.system.exitProcess

fun main() = with(System.`in`.bufferedReader()) {

    val dx = intArrayOf(1, 1, 0, -1)
    val dy = intArrayOf(0, 1, 1, 1)

    val map = Array(19) {
        val st = StringTokenizer(readLine())
        Array(19) { st.nextToken().toInt() }
    }

    repeat(19) { x ->
        repeat(19) { y ->
            if (map[x][y] != 0) {
                val color = map[x][y]
                for (i in 0..3) {
                    var cnt = 1
                    var nx = x + dx[i]
                    var ny = y + dy[i]

                    while (nx in 0 until 19 && ny in 0 until 19 && map[nx][ny] == color) {
                        cnt++

                        if (cnt == 5) {
                            val prevX = x - dx[i]
                            val prevY = y - dy[i]
                            val nextX = nx + dx[i]
                            val nextY = ny + dy[i]

                            if (prevX in 0 until 19 && prevY in 0 until 19 && map[prevX][prevY] == color) break
                            if (nextX in 0 until 19 && nextY in 0 until 19 && map[nextX][nextY] == color) break

                            println(color)
                            println("${x + 1} ${y + 1}")
                            exitProcess(0)
                        }

                        nx += dx[i]
                        ny += dy[i]
                    }
                }
            }
        }
    }

    println(0)
}
