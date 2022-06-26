package baekjoon.silver.s2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var cnt = arrayOf(0, 0)

lateinit var map: Array<Array<Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    map = Array(n) { Array(n) { 0 } }
    repeat(n) { x ->
        val st = StringTokenizer(br.readLine(), " ")
        repeat(n) { y ->
            map[x][y] = st.nextToken().toInt()
        }
    }

    find(n, n - 1, n - 1)

    if (cnt[0] == 0 && cnt[1] == 0) {
        cnt[map[0][0]]++
    }

    println(cnt[0])
    println(cnt[1])
}

fun find(n: Int, x: Int, y: Int): Int {
    if (n == 1) {
        return map[x][y]
    }

    val partCnt = arrayOf(0, 0, 0)

    partCnt[find(n / 2, x, y)]++
    partCnt[find(n / 2, x - n / 2, y)]++
    partCnt[find(n / 2, x, y - n / 2)]++
    partCnt[find(n / 2, x - n / 2, y - n / 2)]++

    return if (partCnt[0] == 4) 0
    else if (partCnt[1] == 4) 1
    else {
        cnt[0] += partCnt[0]
        cnt[1] += partCnt[1]
        2
    }
}