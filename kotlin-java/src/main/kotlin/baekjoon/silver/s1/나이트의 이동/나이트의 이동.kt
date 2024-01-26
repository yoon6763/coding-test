package baekjoon.silver.s1.`나이트의 이동`

import java.util.*

data class Point(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    // 나이트가 이동할 수 있는 방향
    val dx = intArrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
    val dy = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)

    repeat(readLine().toInt()) {
        val n = readLine().toInt()

        val startXY = readLine().split(" ").map { it.toInt() }
        val start = Point(startXY[0], startXY[1])
        val endXY = readLine().split(" ").map { it.toInt() }
        val end = Point(endXY[0], endXY[1])

        // data class를 == 로 비교하면 내부의 값이 같은지 비교 (equals와 같은 역할)
        if (start == end) {
            sb.append(0).append("\n")
            return@repeat
        }


        // 일반적인 bfs와 동일
        val visited = Array(n) { IntArray(n) }

        val q = LinkedList<Point>() as Queue<Point>
        q.offer(start)
        visited[start.x][start.y] = 1

        bfs@ while (q.isNotEmpty()) {
            val target = q.poll()

            for (i in 0 until 8) {
                val nx = target.x + dx[i]
                val ny = target.y + dy[i]

                if (nx !in 0 until n || ny !in 0 until n || visited[nx][ny] != 0) continue

                if (nx == end.x && ny == end.y) {
                    sb.append(visited[target.x][target.y]).append("\n")
                    break@bfs
                }

                visited[nx][ny] = visited[target.x][target.y] + 1
                q.offer(Point(nx, ny))
            }
        }
    }

    print(sb)
}