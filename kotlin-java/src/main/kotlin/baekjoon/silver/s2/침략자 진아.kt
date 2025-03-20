package baekjoon.silver.s2

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    data class Node(val x: Int, val y: Int)
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val parseToXY = { i: Int -> i / m to i % m }
    val map = Array(n) { readLine().toCharArray() }
    var answer = Int.MAX_VALUE
    val countOfVillage = map.sumOf { it.count { it == '1' } }

    for (i in 0..<n * m) {
        val (x1, y1) = parseToXY(i)
        if (map[x1][y1] != '0') continue

        for (j in i + 1..<n * m) {
            val (x2, y2) = parseToXY(j)

            if (map[x2][y2] != '0') continue

            val q = LinkedList<Node>() as Queue<Node>
            val visited = Array(n) { IntArray(m) { -1 } }

            q.add(Node(x1, y1))
            visited[x1][y1] = 0
            q.add(Node(x2, y2))
            visited[x2][y2] = 0

            var count = 0

            bfs@ while (q.isNotEmpty()) {
                val (cx, cy) = q.poll()

                for (k in 0..<4) {
                    val nx = cx + dx[k]
                    val ny = cy + dy[k]

                    if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] != -1) continue
                    if (map[nx][ny] == '1') count++
                    visited[nx][ny] = visited[cx][cy] + 1
                    q.add(Node(nx, ny))

                    if (count != countOfVillage) continue
                    answer = answer.coerceAtMost(visited[nx][ny])
                    break@bfs
                }
            }
        }
    }

    println(answer)
}