package baekjoon.silver.s1.`워리어앤수액빨이둡구리가 정보섬에 올라온 이유`

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val visited = Array(n) { IntArray(m) }
    val q = LinkedList<Node>() as Queue<Node>

    val map = Array(n) { x ->
        val line = readLine().toCharArray()
        for (y in line.indices) {
            if (line[y] == '2') {
                q.offer(Node(x, y))
                visited[x][y] = 1
            }
        }
        line
    }

    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0..<4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]
            if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] == '1' || visited[nx][ny] != 0) continue
            if (map[nx][ny] != '0') {
                println("TAK")
                println(visited[cur.x][cur.y])
                return
            }
            visited[nx][ny] = visited[cur.x][cur.y] + 1
            q.offer(Node(nx, ny))
        }
    }
    println("NIE")
}