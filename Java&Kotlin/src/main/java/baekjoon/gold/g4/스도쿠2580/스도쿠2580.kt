package baekjoon.gold.g4.스도쿠2580

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer
import kotlin.system.exitProcess

var map = Array(9) { Array(9) { 0 } }

data class Point(var x: Int, var y: Int)

val zeroPointArray = ArrayList<Point>()
var emptyCount = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    repeat(9) { x ->
        val st = StringTokenizer(br.readLine())
        repeat(9) { y ->
            map[x][y] = st.nextToken().toInt()
            if (map[x][y] == 0) zeroPointArray.add(Point(x, y))
        }
    }
    emptyCount = zeroPointArray.size
    dfs(0)
}

fun dfs(depth: Int) {
    if (depth == emptyCount) {
        val sb = StringBuilder()
        map.forEach { it ->
            it.forEach { it2 ->
                sb.append(it2).append(" ")
            }
            sb.append("\n")
        }
        print(sb)
        exitProcess(0)
    }

    val point = zeroPointArray[depth]
    val foundKey = findKeys(point.x, point.y)

    for (i in 0 until foundKey.size) {
        map[point.x][point.y] = foundKey[i]
        dfs(depth + 1)
        map[point.x][point.y] = 0
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

    val result = ArrayList<Int>()
    for (i in 1..9) if (!nums[i]) result.add(i)

    return result
}