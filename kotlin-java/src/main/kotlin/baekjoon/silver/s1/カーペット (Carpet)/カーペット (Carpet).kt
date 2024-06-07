package baekjoon.silver.s1.`カーペット (Carpet)`

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val map = Array(n) { readLine() }
    val visited = Array(n) { IntArray(m) }

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    val q = ArrayDeque<Node>()
    q.add(Node(0, 0))
    visited[0][0] = 1

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (i in 0..<4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] != 0 || map[cur.x][cur.y] == map[nx][ny]) continue
            visited[nx][ny] = visited[cur.x][cur.y] + 1
            q.add(Node(nx, ny))
        }
    }

    println(visited[n - 1][m - 1] - 1)
}