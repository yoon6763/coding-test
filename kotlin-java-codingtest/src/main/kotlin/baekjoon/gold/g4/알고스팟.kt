package baekjoon.gold.g4

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }

    val map = Array(n) { readLine().toCharArray().map { it.digitToInt() } }
    val q = ArrayDeque<Triple<Int, Int, Int>>()

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    val visited = Array(n) { BooleanArray(m) }
    visited[0][0] = true
    q.add(Triple(0, 0, 0))

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (i in 0 until 4) {
            val nx = cur.first + dx[i]
            val ny = cur.second + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny]) continue
            visited[nx][ny] = true

            if (map[nx][ny] == 0) {
                q.addFirst(Triple(nx, ny, cur.third))
            } else {
                q.addLast(Triple(nx, ny, cur.third + 1))
            }

            if (nx == n - 1 && ny == m - 1) {
                println(cur.third)
                return
            }
        }
    }

    println(0)
}