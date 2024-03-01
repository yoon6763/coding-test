package baekjoon.gold.g4.`미로 탈출`

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

data class Node(val x: Int, val y: Int, val wallState: Int)

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val (startX, startY) = readLine().split(" ").map { it.toInt() - 1 }
    val (endX, endY) = readLine().split(" ").map { it.toInt() - 1 }
    val map = Array(n) {
        val st = StringTokenizer(readLine())
        List(m) { st.nextToken().toInt() }
    }

    val visited = Array(n) { Array(m) { Array(2) { 0 } } }
    val q = LinkedList<Node>() as Queue<Node>
    visited[startX][startY][0] = 1
    q.offer(Node(startX, startY, 0))

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0..<4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0..<n || ny !in 0..<m) continue

            if (nx == endX && ny == endY) {
                println(visited[cur.x][cur.y][cur.wallState])
                return
            }

            if (map[nx][ny] == 1) {
                if (cur.wallState == 0 && visited[nx][ny][1] == 0) {
                    visited[nx][ny][1] = visited[cur.x][cur.y][0] + 1
                    q.offer(Node(nx, ny, 1))
                }
            } else {
                if (visited[nx][ny][cur.wallState] == 0) {
                    visited[nx][ny][cur.wallState] = visited[cur.x][cur.y][cur.wallState] + 1
                    q.offer(Node(nx, ny, cur.wallState))
                }
            }
        }
    }

    println(-1)
}