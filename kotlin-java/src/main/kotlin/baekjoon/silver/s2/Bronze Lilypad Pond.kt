package baekjoon.silver.s2

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    data class Node(val x: Int, val y: Int)

    val (n, m, m1, m2) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    var startX = 0
    var startY = 0
    var endX = 0
    var endY = 0

    for (i in 0..<n) {
        val st = StringTokenizer(readLine())
        for (j in 0..<m) {
            map[i][j] = st.nextToken().toInt()
            if (map[i][j] == 3) {
                startX = i
                startY = j
            } else if (map[i][j] == 4) {
                endX = i
                endY = j
            }
        }
    }

    val dx = intArrayOf(m1, m1, -m1, -m1, m2, m2, -m2, -m2)
    val dy = intArrayOf(m2, -m2, m2, -m2, m1, -m1, m1, -m1)

    val q: Queue<Pair<Node, Int>> = LinkedList()
    val visited = Array(n) { BooleanArray(m) }
    q.add(Node(startX, startY) to 0)
    visited[startX][startY] = true

    while (q.isNotEmpty()) {
        val (cur, depth) = q.poll()
        if (cur.x == endX && cur.y == endY) {
            println(depth)
            return
        }

        for (i in 0..<8) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] || !(map[nx][ny] == 1 || map[nx][ny] == 4)) continue
            visited[nx][ny] = true
            q.add(Node(nx, ny) to (depth + 1))
        }
    }
}