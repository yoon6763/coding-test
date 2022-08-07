package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)

    val rct = br.readLine().split(" ")
    val r = rct[0].toInt()
    val c = rct[1].toInt()
    val t = rct[2].toInt()

    val map = Array(r) { Array(c) { 0 } }
    val copyMap = Array(r) { Array(c) { 0 } }
    val airCleaner = Array(2) { 0 } // 열은 어차피 0으로 고정, 행 값만 받음

    var cleanerCnt = 0
    repeat(r) { x ->
        val st = StringTokenizer(br.readLine(), " ")
        repeat(c) { y ->
            map[x][y] = st.nextToken().toInt()

            if (map[x][y] == -1) airCleaner[cleanerCnt++] = x
        }
    }

    for (case in 0 until t) {

        // 맵 복사
        repeat(r) { x ->
            repeat(c) { y ->
                copyMap[x][y] = map[x][y]
            }
        }

        // 미세먼지 확산
        repeat(r) { x ->
            repeat(c) { y ->
                if (map[x][y] > 0) {
                    var spreadCnt = 0

                    for (i in 0 until 4) {
                        val nx = x + dx[i]
                        val ny = y + dy[i]

                        if (nx !in 0 until r || ny !in 0 until c || map[nx][ny] == -1) continue

                        copyMap[nx][ny] += map[nx][ny] / 5
                        spreadCnt++
                    }
                    copyMap[x][y] -= map[x][y] / 5 * spreadCnt
                }
            }
        }


        // 공기청정기 가동 (상부)
        for (i in airCleaner[0] - 1 downTo 1) {
            copyMap[i][0] = copyMap[i - 1][0]
        }

        for (i in 0 until c - 1) {
            copyMap[0][i] = copyMap[0][i + 1]
        }

        for (i in 0 until airCleaner[0] - 1) {
            copyMap[i][c - 1] = copyMap[i + 1][c - 1]
        }

        for (i in c - 1 downTo 1) {
            copyMap[airCleaner[0]][i] = copyMap[airCleaner[0]][i - 1]
        }


        // 공기청정기 가동 (하부)
        for (i in airCleaner[1] + 1 until r - 1) {
            copyMap[i][0] = copyMap[i + 1][0]
        }
        for (i in 0 until c - 1) {
            copyMap[0][i] = copyMap[0][i + 1]
        }
        for (i in r - 1 downTo airCleaner[1]) {
            copyMap[i][c - 1] = copyMap[i - 1][c - 1]
        }
        for (i in c - 1 downTo 1) {
            copyMap[airCleaner[1]][i] = copyMap[airCleaner[1]][i - 1]
        }

        copyMap[1][airCleaner[0]] = 0
        copyMap[1][airCleaner[1]] = 0


        // 맵 복사
        repeat(r) { x ->
            repeat(c) { y ->
                map[x][y] = copyMap[x][y]
            }
        }
    }

    var result = 0

    repeat(r) { x ->
        repeat(c) { y ->
            if (map[x][y] != -1) result += map[x][y]
        }
    }

    println(result)
}