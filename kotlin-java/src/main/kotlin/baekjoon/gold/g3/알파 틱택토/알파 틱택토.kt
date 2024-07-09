package baekjoon.gold.g3.`알파 틱택토`

import java.util.StringTokenizer

lateinit var map: Array<IntArray>
const val WIN = 1
const val LOSE = 2
var initialTurn = -1

fun main() = with(System.`in`.bufferedReader()) {
    var xCount = 0
    var oCount = 0

    map = Array(3) {
        val st = StringTokenizer(readLine())
        IntArray(3) {
            val input = st.nextToken().toInt()
            if (input == 1) xCount++
            else if (input == 2) oCount++
            input
        }
    }

    initialTurn = if (xCount == oCount) 1 else 2

    println(
        when (playGame(initialTurn)) {
            1 -> "W"
            0 -> "D"
            else -> "L"
        }
    )
}

fun playGame(turn: Int): Int {
    var min = 2

    for (x in 0 until 3) {
        for (y in 0 until 3) {
            if (map[x][y] != 0) continue
            map[x][y] = turn
            if (isGameEnd(turn)) min = minOf(min, -1)
            min = minOf(min, playGame(3 - turn))
            map[x][y] = 0
        }
    }

    return when (min) {
        1 -> -1
        2, 0 -> 0
        else -> 1
    }
}

fun isGameEnd(turn: Int): Boolean {
    for (i in 0..<3) {
        if (map[i][0] == map[i][1] && map[i][1] == map[i][2] && map[i][0] == turn) return true
        if (map[0][i] == map[1][i] && map[1][i] == map[2][i] && map[0][i] == turn) return true
    }

    if (map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[0][0] == turn) return true
    if (map[0][2] == map[1][1] && map[1][1] == map[2][0] && map[0][2] == turn) return true

    return false
}