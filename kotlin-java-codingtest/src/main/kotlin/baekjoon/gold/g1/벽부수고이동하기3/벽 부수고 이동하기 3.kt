package baekjoon.gold.g1.벽부수고이동하기3

import java.util.*

data class Node(val x: Int, val y: Int, val wallRemoveCnt: Int, var distance: Int, var isDay: Boolean)

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { Array(m) { 0 } }

    repeat(n) { x ->
        val line = readLine()
        repeat(m) { y ->
            // 지나가지 못하는 벽을 -1로 두고, 지나갈 수 있는 곳을 0으로 둠
            map[x][y] = (line[y] - '0') * -1
        }
    }

    val visited = Array(n) { Array(m) { Array(k + 1) { false } } }

    val q = LinkedList<Node>() as Queue<Node>
    visited[0][0][0] = true
    q.offer(Node(0, 0, 0, 1, true))
    var ans = Int.MAX_VALUE

    while (q.isNotEmpty()) {
        val target = q.poll()

        // 만약 벽을 무녀뜨렸다면 1, 무너뜨린 적이 없다면 0
        if (target.x == n - 1 && target.y == m - 1) {
            ans = minOf(ans, target.distance)
            continue
        }

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m) continue

            if (map[nx][ny] == 0 && !visited[nx][ny][target.wallRemoveCnt]) {
                // 벽 아님
                visited[nx][ny][target.wallRemoveCnt] = true
                q.offer(Node(nx, ny, target.wallRemoveCnt, target.distance + 1, !target.isDay))
            } else if (map[nx][ny] == -1 && target.wallRemoveCnt < k && !visited[nx][ny][target.wallRemoveCnt + 1]) {
                // 벽을 만남, 벽 부순적 없음(false - 0)

                // 낮에만 벽을 부술 수 있음
                if(target.isDay) {
                    q.offer(Node(nx, ny, target.wallRemoveCnt + 1, target.distance + 1, false))
                    visited[nx][ny][target.wallRemoveCnt + 1] = true
                }
                else q.offer(Node(target.x, target.y, target.wallRemoveCnt, target.distance + 1, true))
            }
        }
    }
    println(if (ans == Int.MAX_VALUE) -1 else ans)
}