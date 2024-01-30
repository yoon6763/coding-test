package baekjoon.gold.g4.`스도쿠 2580`

import java.lang.StringBuilder
import java.util.StringTokenizer
import kotlin.system.exitProcess

data class Point(var x: Int, var y: Int)

var map = Array(9) { Array(9) { 0 } }
val emptyPointList = ArrayList<Point>()
var emptyCount = 0

fun main() = with(System.`in`.bufferedReader()) {
    repeat(9) { x ->
        val st = StringTokenizer(readLine())
        repeat(9) { y ->
            map[x][y] = st.nextToken().toInt()
            if (map[x][y] == 0) emptyPointList.add(Point(x, y))
        }
    }
    emptyCount = emptyPointList.size
    dfs(0)
}

fun dfs(depth: Int) {
    if (depth == emptyCount) {
        val sb = StringBuilder()
        map.forEach {
            sb.appendLine(it.joinToString(" "))
        }
        print(sb)
        exitProcess(0)
    }

    val curPoint = emptyPointList[depth]
    val foundKey = findKeys(curPoint.x, curPoint.y)

    for (i in 0 until foundKey.size) {
        map[curPoint.x][curPoint.y] = foundKey[i]
        dfs(depth + 1)
        map[curPoint.x][curPoint.y] = 0
    }
}

fun findKeys(x: Int, y: Int): ArrayList<Int> {
    val nums = Array(10) { false }

    for (i in 0 until 9) nums[map[x][i]] = true
    for (i in 0 until 9) nums[map[i][y]] = true

    val squareX = when (x) {
        0, 1, 2 -> 0
        3, 4, 5 -> 3
        6, 7, 8 -> 6
        else -> -1
    }

    val squareY = when (y) {
        0, 1, 2 -> 0
        3, 4, 5 -> 3
        6, 7, 8 -> 6
        else -> -1
    }

    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (i == x && j == y) continue
            nums[map[squareX + i][squareY + j]] = true
        }
    }

    return ArrayList<Int>().apply {
        for (i in 1..9) if (!nums[i]) add(i)
    }
}