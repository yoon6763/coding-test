package baekjoon.silver.s2

import kotlin.collections.ArrayDeque

fun main() = repeat(readln().trim().toInt()) {
    val n = readln().trim().toInt()
    val map = Array(n) { readln().trim().toCharArray() }

    val visited = Array(n) { BooleanArray(n) }
    val q = ArrayDeque<Pair<Int, Int>>()

    for (x in 0..<n) {
        for (y in 0..<n) {
            if (map[x][y] == 'w') q.addLast(x to y)
        }
    }

    var count = 0
    val dx = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
    val dy = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        for (i in 0..<8) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx !in 0..<n || ny !in 0..<n || visited[nx][ny] || map[nx][ny] != '-') continue
            visited[nx][ny] = true
            count++
            q.addLast(nx to ny)
        }
    }

    println(count)
}