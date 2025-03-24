package baekjoon.gold.g5.`도넛 행성`

import java.util.*

data class Node(val x: Int, val y: Int)

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    var answer = 0

    val arr = Array(n) {
        val st = StringTokenizer(readLine())
        IntArray(m) { st.nextToken().toInt() }
    }

    val visited = Array(n) { BooleanArray(m) }

    val q = ArrayDeque<Node>()

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (visited[i][j] || arr[i][j] == 1) continue
            q.add(Node(i, j))
            visited[i][j] = true
            answer++

            while (q.isNotEmpty()) {
                val (x, y) = q.poll()

                for (k in 0..<4) {
                    var nx = x + dx[k]
                    var ny = y + dy[k]

                    if (nx >= n) nx = 0
                    if (nx < 0) nx = n - 1
                    if (ny >= m) ny = 0
                    if (ny < 0) ny = m - 1
                    if (visited[nx][ny] || arr[nx][ny] == 1) continue

                    q.add(Node(nx, ny))
                    visited[nx][ny] = true
                }
            }
        }
    }

    println(answer)
}