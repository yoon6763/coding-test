package baekjoon.gold.g4.`불`

import java.util.*

data class Node(var x: Int, var y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(1, -1, 0, 0)
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val (m, n) = readLine().split(" ").map { it.toInt() }

        val start = Node(0, 0)
        val fireList = LinkedList<Node>() as Queue<Node>
        val map = Array(n) { Array(m) { ' ' } }
        repeat(n) { x ->
            val line = readLine()
            repeat(m) { y ->
                map[x][y] = line[y]
                if (map[x][y] == '@') {
                    start.x = x
                    start.y = y
                } else if (map[x][y] == '*') {
                    fireList.add(Node(x, y))
                }
            }
        }

        val visited = Array(n) { Array(m) { 0 } }
        val queue = LinkedList<Node>() as Queue<Node>
        queue.offer(start)
        visited[start.x][start.y] = 1

        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val cur = queue.poll()
                if(map[cur.x][cur.y] == '*') continue

                for (j in 0 until 4) {
                    val nx = cur.x + dx[j]
                    val ny = cur.y + dy[j]

                    if (nx !in 0 until n || ny !in 0 until m) {
                        sb.append(visited[cur.x][cur.y]).append("\n")
                        return@repeat
                    }
                    if (visited[nx][ny] != 0 || map[nx][ny] == '#' || map[nx][ny] == '*') continue
                    queue.offer(Node(nx, ny))
                    visited[nx][ny] = visited[cur.x][cur.y] + 1
                }
            }

            // 불을 확산시킴
            for (i in 0 until fireList.size) {
                val target = fireList.poll()

                for (j in 0 until 4) {
                    val nx = target.x + dx[j]
                    val ny = target.y + dy[j]

                    if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == '#' || map[nx][ny] == '*') {
                        continue
                    }

                    map[nx][ny] = '*'
                    val node = Node(nx, ny)
                    if (node !in fireList) fireList.add(node)
                }
            }
        }
        sb.append("IMPOSSIBLE\n")
    }

    print(sb)
}