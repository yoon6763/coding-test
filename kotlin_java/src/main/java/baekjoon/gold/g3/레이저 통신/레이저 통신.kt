package baekjoon.gold.g3.`레이저 통신`

import java.util.*

data class Node(val x: Int, val y: Int, val dir: Int)

val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, -1, 0, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }

    val map = Array(n) { readLine().toCharArray() }
    val points = ArrayList<Node>()

    repeat(n) { x ->
        repeat(m) { y ->
            if (map[x][y] == 'C') points.add(Node(x, y, 0))
        }
    }

    val (start, end) = points
    val queue = LinkedList<Node>() as Queue<Node>
    val visited = Array(n) { Array(m) { IntArray(4) } }

    repeat(4) {
        queue.add(Node(start.x, start.y, it))
        visited[start.x][start.y][it] = 1
    }

    while (queue.isNotEmpty()) {
        val (x, y, dir) = queue.poll()

        for (deltaDir in arrayOf(1, -1)) {
            for (distance in 1..100) {
                var nd = dir + deltaDir
                if (nd == -1) nd = 3
                if (nd == 4) nd = 0

                val nx = x + dx[nd] * distance
                val ny = y + dy[nd] * distance

                if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] == '*') break
                if (visited[nx][ny][nd] != 0) continue

                if (nx == end.x && ny == end.y) {
                    println(visited[x][y][dir] - 1)
                    return
                }

                visited[nx][ny][nd] = visited[x][y][dir] + 1
                queue.add(Node(nx, ny, nd))
            }
        }
    }
}