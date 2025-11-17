package baekjoon.gold.g5

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {

    // 북동남서 순
    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    val (n, m) = readLine().split(" ").map { it.toInt() }
    var (robotX, robotY, robotD) = readLine().split(" ").map { it.toInt() }
    // 0123 : 북동남서 순

    val map = Array(n) {
        val st = StringTokenizer(readLine())
        Array(m) { st.nextToken().toInt() }
    }

    var cnt = 0

    turn@ while (true) {
        // 현재 칸이 청소되어 있지 않음 -> 청소
        if (map[robotX][robotY] == 0) {
            map[robotX][robotY] = -1
            cnt++
        } else if (map[robotX][robotY] == 1) {
            break@turn
        }

        for (i in 0 until 4) {
            if (--robotD == -1) robotD = 3

            val nx = robotX + dx[robotD]
            val ny = robotY + dy[robotD]

            // 청소하지 않은 곳을 발견하면 이동
            if (map[nx][ny] == 0) {
                robotX = nx
                robotY = ny
                continue@turn
            }
        }

        // 4 방향 모두 다 이미 청소했다면? -> 후진
        robotX -= dx[robotD]
        robotY -= dy[robotD]
    }

    println(cnt)
}