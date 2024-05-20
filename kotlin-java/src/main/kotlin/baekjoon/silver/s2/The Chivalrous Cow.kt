package baekjoon.silver.s2

fun main() = with(System.`in`.bufferedReader()) {
    class Node(val x: Int, val y: Int)

    val (m, n) = readLine().split(" ").map { it.toInt() }

    var start = Node(0, 0)
    var end = Node(0, 0)
    val map = Array(n) { i ->
        val line = readLine().toCharArray()
        for (j in line.indices) {
            if (line[j] == 'K') start = Node(i, j)
            if (line[j] == 'H') end = Node(i, j)
        }
        line
    }

    val dx = intArrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
    val dy = intArrayOf(-1, 1, -2, 2, -2, 2, -1, 1)

    val visited = Array(n) { IntArray(m) { 0 } }

    val q = ArrayDeque<Node>()
    q.add(start)
    visited[start.x][start.y] = 1

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (i in dx.indices) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] != 0 || map[nx][ny] == '*') continue

            visited[nx][ny] = visited[cur.x][cur.y] + 1
            q.addLast(Node(nx, ny))

            if (nx == end.x && ny == end.y) {
                println(visited[nx][ny] - 1)
                return
            }
        }
    }

    visited.forEach { println(it.contentToString()) }
}