package baekjoon.platinum.p3.`달리기`

import java.util.*
import kotlin.collections.ArrayDeque

data class Node(val x: Int, val y: Int)

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val (n, m, k) = List(3) { st.nextToken().toInt() }
    val arr = Array(n) { readLine().toCharArray() }
    val visited = Array(n) { IntArray(m) { Int.MAX_VALUE } }

    st = StringTokenizer(readLine())
    val (sx, sy, ex, ey) = List(4) { st.nextToken().toInt() - 1 }

    val q = ArrayDeque<Node>()
    q.add(Node(sx, sy))
    visited[sx][sy] = 0

    bfs@ while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (i in 0..<4) {
            for (j in 1..k) {
                val nx = cur.x + dx[i] * j
                val ny = cur.y + dy[i] * j

                if (nx !in 0..<n || ny !in 0..<m || arr[nx][ny] == '#') break

                if (nx == ex && ny == ey) {
                    visited[nx][ny] = visited[cur.x][cur.y] + 1
                    break@bfs
                }

                if (visited[nx][ny] <= visited[cur.x][cur.y]) break
                if (arr[nx][ny] != '.' || visited[nx][ny] != Int.MAX_VALUE) continue
                q.add(Node(nx, ny))
                visited[nx][ny] = visited[cur.x][cur.y] + 1
            }
        }
    }

    println(if (visited[ex][ey] == Int.MAX_VALUE) -1 else visited[ex][ey])
}