package baekjoon.gold.g3.`벽 부수고 이동하기 2`

import java.util.*

data class Node(val x: Int, val y: Int, val wallRemoveCnt: Int)

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { Array(m) { Array(k + 1) { 0 } } }

    repeat(n) { x ->
        val line = readLine()
        repeat(m) { y ->
            // 지나가지 못하는 벽을 -1로 두고, 지나갈 수 있는 곳을 0으로 둠
            map[x][y][0] = (line[y] - '0') * -1
        }
    }

    val q = LinkedList<Node>() as Queue<Node>
    map[0][0][0] = 1
    q.offer(Node(0, 0, 0))

    while (q.isNotEmpty()) {
        val target = q.poll()

        // 만약 벽을 무녀뜨렸다면 1, 무너뜨린 적이 없다면 0
        if (target.x == n - 1 && target.y == m - 1) {
            println(map[target.x][target.y][target.wallRemoveCnt])
            return
        }

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m) continue

            if (map[nx][ny][0] == 0 && map[nx][ny][target.wallRemoveCnt] == 0) {
                // 벽 아님
                map[nx][ny][target.wallRemoveCnt] = map[target.x][target.y][target.wallRemoveCnt] + 1
                q.offer(Node(nx, ny, target.wallRemoveCnt))
            } else if (map[nx][ny][0] == -1 && target.wallRemoveCnt < k && map[nx][ny][target.wallRemoveCnt + 1] == 0) {
                // 벽을 만남, 벽 부순적 없음(false - 0)

                map[nx][ny][target.wallRemoveCnt + 1] = map[target.x][target.y][target.wallRemoveCnt] + 1
                q.offer(Node(nx, ny, target.wallRemoveCnt + 1))
            }
        }
    }
    println(-1)
}