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

    var map = Array(r + 1) { Array(c + 1) { 0 } }
    val airCleaner = Array(2) { 0 } // 열은 어차피 0으로 고정, 행 값만 받음

    var cleanerCnt = 0
    for (x in 1..r) {
        val st = StringTokenizer(br.readLine(), " ")
        for (y in 1..c) {
            map[x][y] = st.nextToken().toInt()

            if (map[x][y] == -1) airCleaner[cleanerCnt++] = x
        }
    }


    for (case in 0 until t) {
        val copyMap = Array(r+1) { Array(c+1) {0} }

        // 미세먼지 확산
        for (x in 1..r) {
            for (y in 1..c) {
                if (map[x][y] <= 0) {
                    if (map[x][y] == -1) copyMap[x][y] = map[x][y]
                    continue
                }

                var spreadCnt = 0

                for (i in 0 until 4) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]

                    if (nx !in 1 .. r || ny !in 1 .. c || map[nx][ny] == -1) continue

                    copyMap[nx][ny] += map[x][y] / 5
                    spreadCnt++
                }
                copyMap[x][y] += map[x][y] - (map[x][y] / 5 * spreadCnt)
            }
        }

        // 맵 복사
        map = copyMap

        for (i in airCleaner[0] - 1 downTo 2) {
            map[i][1] = map[i - 1][1]
        }

        for (i in 1 until c) {
            map[1][i] = map[1][i + 1]
        }

        for (i in 1 until airCleaner[0]) {
            map[i][c] = map[i + 1][c]
        }

        for (i in c downTo 3) {
            map[airCleaner[0]][i] = map[airCleaner[0]][i - 1]
        }
        map[airCleaner[0]][2] = 0

        for (i in airCleaner[1] + 1 until r) {
            map[i][1] = map[i + 1][1]
        }
        for (i in 0 until c) {
            map[r][i] = map[r][i + 1]
        }
        for (i in r downTo airCleaner[1] + 1) {
            map[i][c] = map[i - 1][c]
        }
        for (i in c downTo 3) {
            map[airCleaner[1]][i] = map[airCleaner[1]][i - 1]
        }
        map[airCleaner[1]][2] = 0
    }

    var result = 0

    for (x in 1..r) {
        for (y in 1..c) {
            if (map[x][y] > 0) result += map[x][y]
        }
    }

    println(result)
}