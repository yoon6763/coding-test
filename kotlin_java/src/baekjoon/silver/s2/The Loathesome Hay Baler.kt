package baekjoon.silver.s2

import kotlin.math.abs
import kotlin.math.pow

data class Roller(val x: Int, val y: Int, val r: Int)

fun main() {
    val (n, endX, endY) = readln().split(" ").map { it.toInt() }
    val rollers = Array(n) {
        val (x, y, r) = readln().split(" ").map { it.toInt() }
        Roller(x, y, r)
    }

    val visited = BooleanArray(n)
    val speed = DoubleArray(n)
    val start = rollers.indexOfFirst { it.x == 0 && it.y == 0 }

    fun dfs(cur: Int, sum: Double) {
        if (rollers[cur].x == endX && rollers[cur].y == endY) {
            println(sum.toInt())
            return
        }
        for (i in rollers.indices) {
            if (visited[i]) continue
            val distance = (rollers[i].x - rollers[cur].x).toDouble().pow(2.0) +
                    (rollers[i].y - rollers[cur].y).toDouble().pow(2.0)
            val rSum = (rollers[i].r + rollers[cur].r).toDouble().pow(2.0)
            if (abs(distance - rSum) >= 1e-6) continue
            visited[i] = true
            speed[i] = -speed[cur] * rollers[cur].r / rollers[i].r
            dfs(i, sum + abs(speed[i]))
        }
    }

    speed[start] = 10000.0
    visited[start] = true
    dfs(start, abs(speed[start]))
}
