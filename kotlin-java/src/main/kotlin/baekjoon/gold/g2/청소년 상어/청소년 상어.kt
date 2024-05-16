package baekjoon.gold.g2.`청소년 상어`

import java.util.*

data class Fish(var x: Int, var y: Int, var dir: Int, var isAlive: Boolean)

lateinit var map: Array<IntArray>

const val SHARK = -1
const val EMPTY = -2

//  ↑, ↖, ←, ↙, ↓, ↘, →, ↗
val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
val dy = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)
val fishList = Array(17) { Fish(-1, -1, -1, false) }
var ans = 0

fun main() = with(System.`in`.bufferedReader()) {
    map = Array(4) { IntArray(4) }

    repeat(4) { x ->
        val st = StringTokenizer(readLine())

        repeat(4) { y ->
            val fishNum = st.nextToken().toInt()
            val fishDir = st.nextToken().toInt() - 1
            fishList[fishNum] = Fish(x, y, fishDir, true)
            map[x][y] = fishNum
        }
    }

    val eatFishNumber = map[0][0]
    val eatFishDir = fishList[eatFishNumber].dir
    fishList[eatFishNumber].isAlive = false
    map[0][0] = SHARK

    moveSharkDFS(0, 0, eatFishDir, eatFishNumber, fishList, map)
    println(ans)
}

fun moveSharkDFS(sharkX: Int, sharkY: Int, dir: Int, scoreSum: Int, fishList: Array<Fish>, map: Array<IntArray>) {
    ans = maxOf(ans, scoreSum)
    moveFish(fishList, map)

    for (i in 1..3) {
        val fishX = sharkX + dx[dir] * i
        val fishY = sharkY + dy[dir] * i

        if (fishX !in 0..<4 || fishY !in 0..<4) break

        val copiedFishList = Array(17) { fishList[it].copy() }
        val copiedMap = Array(4) { x -> IntArray(4) { y -> map[x][y] } }

        if (copiedMap[fishX][fishY] != EMPTY) {
            val eatFishNumber = copiedMap[fishX][fishY]
            val eatFishDir = fishList[eatFishNumber].dir

            copiedFishList[eatFishNumber].isAlive = false

            copiedMap[fishX][fishY] = SHARK
            copiedMap[sharkX][sharkY] = EMPTY

            moveSharkDFS(fishX, fishY, eatFishDir, scoreSum + eatFishNumber, copiedFishList, copiedMap)
        }
    }
}

fun moveFish(fishList: Array<Fish>, map: Array<IntArray>) {
    for (i in 1..16) {
        if (!fishList[i].isAlive) continue

        val x = fishList[i].x
        val y = fishList[i].y
        var dir = fishList[i].dir

        for(j in 0..<8) {
            val nx = x + dx[dir]
            val ny = y + dy[dir]

            if (nx in 0..<4 && ny in 0..<4 && map[nx][ny] != SHARK) {
                if (map[nx][ny] == EMPTY) {
                    map[x][y] = EMPTY
                } else {
                    swapFish(x, y, nx, ny, fishList, map)
                }

                map[nx][ny] = i
                fishList[i].x = nx
                fishList[i].y = ny
                fishList[i].dir = dir
                break
            }

            dir = (dir + 1) % 8
        }
    }
}

fun swapFish(x1: Int, y1: Int, x2: Int, y2: Int, fishList: Array<Fish>, map: Array<IntArray>) {
    val temp = map[x1][y1]
    map[x1][y1] = map[x2][y2]
    map[x2][y2] = temp

    fishList[map[x1][y1]].x = x1
    fishList[map[x1][y1]].y = y1
    fishList[map[x2][y2]].x = x2
    fishList[map[x2][y2]].y = y2
}