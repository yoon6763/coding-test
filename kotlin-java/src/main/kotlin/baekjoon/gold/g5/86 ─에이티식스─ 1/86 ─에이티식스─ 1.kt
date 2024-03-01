package baekjoon.gold.g5.`86 ─에이티식스─ 1`

import kotlin.math.abs

data class Point(val x: Int, val y: Int)

lateinit var enemyVisited: BooleanArray
lateinit var map: Array<IntArray>
val enemies = ArrayList<Point>()
var n = 0
var minTime = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    var startX = 0
    var startY = 0

    map = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        val input = readLine().split(" ").map { it.toInt() }
        for (j in 0 until n) {
            map[i][j] = input[j]

            // 시작 위치
            if (map[i][j] == 2) {
                startX = i
                startY = j
            } else if (map[i][j] == 1) {
                // 적의 위치
                enemies.add(Point(i, j))
            }
        }
    }

    // 대각선으로만 이동 가능함
    // 체스의 비숍 이동 방식 -> 다른 색깔의 칸에 적이 있으면 불가능
    if (startX % 2 == startY % 2) {
        enemies.forEach { enemy ->
            if (enemy.x % 2 != enemy.y % 2) {
                println("Shorei")
                return
            }
        }
    } else {
        enemies.forEach { enemy ->
            if (enemy.x % 2 == enemy.y % 2) {
                println("Shorei")
                return
            }
        }
    }

    enemyVisited = BooleanArray(enemies.size)

    backTracking(startX, startY, 0, 0)

    println("Undertaker")
    println(minTime)
}

fun backTracking(x: Int, y: Int, time: Int, depth: Int) {
    if (depth == enemies.size) {
        minTime = minOf(minTime, time)
        return
    }

    for (i in 0 until enemies.size) {
        if (enemyVisited[i]) continue

        val (nx, ny) = enemies[i]
        // 해당 적의 위치까지 이동하는데 걸리는 시간. 비숍의 이동 방식과 동일
        val spentTime = maxOf(abs(x - nx), abs(y - ny))

        enemyVisited[i] = true
        backTracking(nx, ny, time + spentTime, depth + 1)
        enemyVisited[i] = false
    }
}