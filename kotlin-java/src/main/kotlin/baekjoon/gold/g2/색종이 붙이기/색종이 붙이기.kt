package baekjoon.gold.g2.`색종이 붙이기`

import java.util.StringTokenizer

lateinit var map: Array<Array<Int>>
val pagerCnt = arrayOf(0, 5, 5, 5, 5, 5)
var result = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    map = Array(10) {
        val st = StringTokenizer(readLine())
        Array(10) { st.nextToken().toInt() }
    }

    backTracking(0, 0, 0)

    println(if (result == Int.MAX_VALUE) -1 else result)
}


fun backTracking(x: Int, y: Int, depth: Int) {
    if (x >= 10) {
        result = minOf(result, depth)
        return
    }

    if (depth >= result) return

    if (map[x][y] == 1) {
        paperAttach@ for (i in 5 downTo 1) {
            if (pagerCnt[i] == 0) continue

            // 색종이 붙일 수 있는지 확인
            for (dx in 0 until i) {
                for (dy in 0 until i) {
                    if (x + dx >= 10 || y + dy >= 10 || map[x + dx][y + dy] == 0) continue@paperAttach
                }
            }


            attach(x, y, i, 0)
            pagerCnt[i]--
            if (y + i < 10) {
                backTracking(x, y + i, depth + 1)
            } else {
                backTracking(x + 1, 0, depth + 1)
            }
            pagerCnt[i]++
            attach(x, y, i, 1)
        }
    } else {
        if (y + 1 < 10) {
            backTracking(x, y + 1, depth)
        } else {
            backTracking(x + 1, 0, depth)
        }
    }
}

fun attach(x: Int, y: Int, size: Int, flag: Int) {
    repeat(size) { dx ->
        repeat(size) { dy ->
            map[x + dx][y + dy] = flag
        }
    }
}