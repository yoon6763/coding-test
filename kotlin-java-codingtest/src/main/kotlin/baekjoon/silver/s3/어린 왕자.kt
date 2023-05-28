package baekjoon.silver.s3

import java.util.StringTokenizer
import kotlin.math.pow
import kotlin.math.sqrt

data class Planet(val x: Int, val y: Int, val r: Int)

fun main() = with(System.`in`.bufferedReader()) {

    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        // 진입 / 이탈 횟수 카운트
        var cnt = 0

        val (startX, startY, endX, endY) = readLine().split(" ").map { it.toInt() }

        val planetCnt = readLine().toInt()
        val planetArray = Array<Planet?>(planetCnt) { null }

        repeat(planetCnt) {
            val st = StringTokenizer(readLine())
            // 행성의 x, y, 반지름
            planetArray[it] = Planet(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
        }

        planetArray.forEach {
            val startDistance = getDistance(it!!.x, it.y, startX, startY)
            val endDistance = getDistance(it.x, it.y, endX, endY)

            // 행성이 두 점 모두 포함하거나, 두 점 모두 포함하지 않으면 진입 / 이탈 해야함
            if (!(startDistance > it.r && endDistance > it.r || startDistance < it.r && endDistance < it.r)) {
                cnt++
            }
        }

        sb.append("$cnt\n")
    }
    print(sb)
}

fun getDistance(x1: Int, y1: Int, x2: Int, y2: Int): Double {
    return sqrt((x1 - x2).toDouble().pow(2) + (y1 - y2).toDouble().pow(2))
}