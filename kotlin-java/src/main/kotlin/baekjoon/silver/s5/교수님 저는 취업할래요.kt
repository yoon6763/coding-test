package baekjoon.silver.s5

import kotlin.math.pow
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    var (px, py) = arrayOf(0, 0)
    var (sx, sy) = arrayOf(0, 0)

    val table = Array(n) { x ->
        val line = readLine().split(" ").map { it.toInt() }
        for (y in line.indices) {
            if (line[y] == 5) {
                px = x
                py = y
            }
            if (line[y] == 2) {
                sx = x
                sy = y
            }
        }
        line
    }

    val distance = sqrt((px - sx).toDouble().pow(2) + (py - sy).toDouble().pow(2))
    var studentCnt = 0

    val x = arrayOf(sx, px).sorted()
    val y = arrayOf(sy, py).sorted()

    for (i in x[0]..x[1]) {
        for (j in y[0]..y[1]) {
            if (table[i][j] == 1) studentCnt++
        }
    }

    if(distance >= 5 && studentCnt >= 3) println(1)
    else println(0)
}