package baekjoon.gold.g4.`유닛 이동시키기`

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

const val GOAL = -2
const val WALL = -1

fun main() = with(System.`in`.bufferedReader()) {
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    var (n, m, a, b, k) = readLine().split(" ").map { it.toInt() }
    a--
    b--

    val map = Array(n) { IntArray(m) }
    val visited = Array(n) { IntArray(m) }

    repeat(k) {
        val (x, y) = readLine().split(" ").map { it.toInt() - 1 }
        map[x][y] = WALL
    }

    val (startX, startY) = readLine().split(" ").map { it.toInt() - 1 }
    val (endX, endY) = readLine().split(" ").map { it.toInt() - 1 }
    if (map[endX][endY] == WALL) {
        println(-1)
        return@with
    }
    map[endX][endY] = GOAL

    val q = LinkedList<Node>() as Queue<Node>
    q.offer(Node(startX, startY))
    visited[startX][startY] = 1

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()

        next@ for (i in 0..<4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx !in 0..<n || ny !in 0..<m || nx + a !in 0..<n || ny + b !in 0..<m || visited[nx][ny] != 0 || map[nx][ny] == WALL) continue
            for (unitX in nx..nx + a) {
                for (unitY in ny..ny + b) {
                    if (map[unitX][unitY] == WALL) continue@next
                }
            }

            if (map[nx][ny] == GOAL) {
                println(visited[x][y])
                return@with
            }

            q.offer(Node(nx, ny))
            visited[nx][ny] = visited[x][y] + 1
        }
    }

    println(-1)
}