package baekjoon.gold.g5.チーズ

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, _) = readLine().split(" ").map { it.toInt() }

    val arr = Array(n) { CharArray(m) }
    var start = Node(0, 0)

    for (i in 0..<n) {
        arr[i] = readLine().toCharArray()
        for (j in 0..<m) {
            if (arr[i][j] == 'S') start = Node(i, j)
        }
    }

    val q = LinkedList<Node>() as Queue<Node>
    val visited = Array(n) { IntArray(m) }
    q.add(start)
    visited[start.x][start.y] = 1

    var curLevel = 0
    var ans = 0

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()

        for (i in 0..<4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0..<n || ny !in 0..<m || arr[nx][ny] == 'X' || visited[nx][ny] != 0) continue
            if (arr[nx][ny].isDigit() && arr[nx][ny].digitToInt() == curLevel + 1) {
                ans += visited[x][y]
                curLevel++
                q.clear()
                q.add(Node(nx, ny))
                visited.forEach { it.fill(0) }
                visited[nx][ny] = 1
                break
            }

            visited[nx][ny] = visited[x][y] + 1
            q.add(Node(nx, ny))
        }
    }

    println(ans)
}