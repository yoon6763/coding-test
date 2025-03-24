package baekjoon.silver.s2.`사탕 게임`

import kotlin.math.max

lateinit var board: Array<CharArray>
var max = 1
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    board = Array(n) { readLine().toCharArray() }

    for (i in 0..<n) {
        for (j in 0..<n - 1) {
            swap(i, j, i, j + 1)
            calc()
            swap(i, j + 1, i, j)
        }
    }

    for (i in 0..<n - 1) {
        for (j in 0..<n) {
            swap(i, j, i + 1, j)
            calc()
            swap(i + 1, j, i, j)
        }
    }

    println(max)
}

fun swap(x1: Int, y1: Int, x2: Int, y2: Int) {
    val temp = board[x1][y1]
    board[x1][y1] = board[x2][y2]
    board[x2][y2] = temp
}

fun calc() = repeat(n) {
    var verticalCount = 1
    var horizontalCount = 1

    for (j in 0..<n - 1) {
        if (board[it][j] == board[it][j + 1]) {
            verticalCount++
            max = max(verticalCount, max)
        } else {
            verticalCount = 1
        }
        if (board[j][it] == board[j + 1][it]) {
            horizontalCount++
            max = max(horizontalCount, max)
        } else {
            horizontalCount = 1
        }
    }
}
