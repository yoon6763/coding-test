package baekjoon.gold.g5.IcyPerimeter

import java.util.LinkedList
import java.util.Queue

lateinit var arr: Array<CharArray>
lateinit var visited: Array<BooleanArray>

var n = 0
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = Array(n) { readLine().toCharArray() }
    visited = Array(n) { BooleanArray(n) }

    var maxArea = -1
    var maxPerimeter = -1

    for (i in 0..<n) {
        for (j in 0..<n) {
            if (arr[i][j] == '.' || visited[i][j]) continue

            val (area, perimeter) = calcAreaSizeUsingBFS(i, j)
            if (area > maxArea) {
                maxArea = area
                maxPerimeter = perimeter
            } else if (area == maxArea) {
                maxPerimeter = minOf(maxPerimeter, perimeter)
            }
        }
    }

    println("$maxArea $maxPerimeter")
}

fun calcAreaSizeUsingBFS(x: Int, y: Int): Pair<Int, Int> {
    var area = 0
    var perimeter = 0

    val q: Queue<Node> = LinkedList()
    q.offer(Node(x, y))
    visited[x][y] = true

    while (q.isNotEmpty()) {
        val (curX, curY) = q.poll()
        area++

        for (i in 0..<4) {
            val nx = curX + dx[i]
            val ny = curY + dy[i]

            if (nx !in 0..<n || ny !in 0..<n || arr[nx][ny] == '.') {
                perimeter++
                continue
            }
            if (visited[nx][ny]) continue
            visited[nx][ny] = true
            q.offer(Node(nx, ny))
        }
    }

    return area to perimeter
}