package baekjoon.gold.g4.미로

import java.util.*

data class Node(var x: Int, var y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val start = Node(-1, -1)
    val map = Array(n) { x->
        val line = readLine().toCharArray()
        if(start.x == -1) {
            if('.' in line) {
                start.x = x
                start.y = line.indexOf('.')
            }
        }
        line
    }

    val q = LinkedList<Node>() as Queue<Node>
    val pre = Array(n) { Array<Node?>(m) { null } }
    q.offer(start)
    pre[start.x][start.y] = start

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    bfs@ while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0 until 4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] != '.' || pre[nx][ny] != null) continue

            pre[nx][ny] = cur
            q.offer(Node(nx, ny))

            if (map[nx][ny] == '.' && (nx == 0 || nx == n - 1 || ny == 0 || ny == m - 1)) break@bfs
        }
    }

    val sb = StringBuilder()

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == '.') map[i][j] = '@'
        }
    }

    var cur = q.last()

    while (cur != start) {
        map[cur.x][cur.y] = '.'
        cur = pre[cur.x][cur.y]!!
    }

    map[start.x][start.y] = '.'

    for (i in 0 until n) sb.appendLine(map[i].joinToString(""))
    print(sb)
}