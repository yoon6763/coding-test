package baekjoon.silver.s2

import kotlin.math.pow

fun main() {
    data class Roller(val x: Double, val y: Double, val d: Double)

    val n = readln().toInt()
    val rollers = Array(n) { readln().split(" ").map { it.toDouble() }.let { (x, y, d) -> Roller(x, y, d) } }
    val canMove = { r1: Roller, r2: Roller -> ((r1.x - r2.x).pow(2) + (r1.y - r2.y).pow(2)) == (r1.d + r2.d).pow(2) }

    val visited = BooleanArray(n)
    val startIndex = rollers.indexOfFirst { it.x == 0.0 && it.y == 0.0 }

    var lastMoveIdx = startIndex

    fun dfs(cur: Int) {
        lastMoveIdx = cur
        visited[cur] = true
        for (next in 0..<n) {
            if (cur == next || visited[next] || !canMove(rollers[cur], rollers[next])) continue
            dfs(next)
        }
    }

    dfs(startIndex)
    println("${rollers[lastMoveIdx].x.toInt()} ${rollers[lastMoveIdx].y.toInt()}")
}