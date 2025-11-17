package baekjoon.gold.g5.`다각형의 면적`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.roundToInt
import kotlin.math.roundToLong

data class Point(var x: Long, var y: Long)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val points = Array(n) { Point(0, 0) }

    repeat(n) {
        val line = br.readLine().split(" ").map { it.toLong() }
        points[it].x = line[0]
        points[it].y = line[1]
    }

    var result = 0.0

    for (i in 1..n - 2) {
        result += area(points[0], points[i], points[i + 1])
    }

    println("${String.format("%.1f", abs(result / 2.0))}")
}

fun area(p1: Point, p2: Point, p3: Point): Long {
    return ((p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p1.x * p3.y + p2.x * p1.y + p3.x * p2.y))
}