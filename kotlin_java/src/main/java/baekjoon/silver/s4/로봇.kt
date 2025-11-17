package baekjoon.silver.s4

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    var (x, y) = arrayOf(0, 0)
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    var dir = 1

    repeat(n) {
        val st = StringTokenizer(readLine())
        if (st.nextToken() == "TURN") {
            dir += if (st.nextToken().toInt() == 0) -1 else 1
            if (dir < 0) dir = 3
            if (dir > 3) dir = 0
        } else {
            val dist = st.nextToken().toInt()
            x += dx[dir] * dist
            y += dy[dir] * dist
            if (x >= m || y >= m || x < 0 || y < 0) {
                println(-1)
                return
            }
        }
    }
    println("$x $y")
}