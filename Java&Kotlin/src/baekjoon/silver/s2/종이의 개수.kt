package baekjoon.silver.s2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var cnt_minus_1 = 0
var cnt_0 = 0
var cnt_1 = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val map = Array(n) { Array(n) { 0 } }

    repeat(n) { x ->
        val st = StringTokenizer(br.readLine(), " ")
        repeat(n) { y ->
            map[x][y] = st.nextToken().toInt()
        }
    }

    find(map, n, n - 1, n - 1)

    if(cnt_minus_1 + cnt_0 + cnt_1 == 0) {
        when(map[0][0]) {
            -1 -> cnt_minus_1++
            0 -> cnt_0++
            1 -> cnt_1++
        }
    }

    println(cnt_minus_1)
    println(cnt_0)
    println(cnt_1)


}

fun find(map: Array<Array<Int>>, n: Int, x: Int, y: Int): Int {
    val cnt = arrayOf(0, 0, 0, 0) // -1, 0, 1을 카운트 각 인덱스는 0, 1, 2

    if (n == 1)
        return map[x][y]

    cnt[find(map, n / 3, x, y) + 1]++
    cnt[find(map, n / 3, x, y - n / 3) + 1]++
    cnt[find(map, n / 3, x, y - n / 3 * 2) + 1]++
    cnt[find(map, n / 3, x - n / 3, y) + 1]++
    cnt[find(map, n / 3, x - n / 3, y - n / 3) + 1]++
    cnt[find(map, n / 3, x - n / 3, y - n / 3 * 2) + 1]++
    cnt[find(map, n / 3, x - n / 3 * 2, y) + 1]++
    cnt[find(map, n / 3, x - n / 3 * 2, y - n / 3) + 1]++
    cnt[find(map, n / 3, x - n / 3 * 2, y - n / 3 * 2) + 1]++

    if (cnt[0] == 9)
        return -1
    else if (cnt[1] == 9)
        return 0
    else if (cnt[2] == 9)
        return 1
    else {
        cnt_minus_1 += cnt[0]
        cnt_0 += cnt[1]
        cnt_1 += cnt[2]
        return 2
    }
}