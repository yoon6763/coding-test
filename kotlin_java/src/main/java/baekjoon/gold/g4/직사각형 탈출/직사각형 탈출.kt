package baekjoon.gold.g4.`직사각형 탈출`

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    val st = StringTokenizer(readLine())
    val (h, w) = List(2) { st.nextToken().toInt() }
    val (startX, startY, endX, endY) = List(4) { st.nextToken().toInt() - 1 }

    if (startX == endX && startY == endY) {
        println(0)
        return@with
    }

    for (x in 0..<n) {
        for (y in 0..<m) {
            if (map[x][y] == 0) continue
            for (dh in 0..<h) {
                for (dw in 0..<w) {
                    val nx = x - dh
                    val ny = y - dw
                    if (nx !in 0..<n || ny !in 0..<m) continue
                    map[nx][ny] = 1
                }
            }
        }
    }

    for (i in n - h + 1..<n) {
        for (j in 0..<m) {
            map[i][j] = 1
        }
    }


    for (i in 0..<n) {
        for (j in m - w + 1..<m) {
            map[i][j] = 1
        }
    }

    val visited = Array(n) { IntArray(m) }
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    val q = LinkedList<Node>() as Queue<Node>

    q.offer(Node(startX, startY))
    visited[startX][startY] = 1

    while (q.isNotEmpty()) {
        val cur = q.poll()

        next@ for (i in 0..<4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] != 0 || map[nx][ny] == 1) continue@next

            if (nx == endX && ny == endY) {
                println(visited[cur.x][cur.y])
                return@with
            }

            q.offer(Node(nx, ny))
            visited[nx][ny] = visited[cur.x][cur.y] + 1
        }
    }

    println(-1)
}