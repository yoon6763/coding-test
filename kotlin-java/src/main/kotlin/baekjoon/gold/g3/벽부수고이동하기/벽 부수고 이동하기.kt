package baekjoon.gold.g3.벽부수고이동하기

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Node(val x: Int, val y: Int, val isWallRemove: Boolean)

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    val map = Array(n) { Array(m) { Array(2) { 0 } } }

    repeat(n) { x ->
        val line = br.readLine()
        repeat(m) { y ->
            // 지나가지 못하는 벽을 -1로 두고, 지나갈 수 있는 곳을 0으로 둠
            map[x][y][0] = (line[y] - '0') * -1
        }
    }

    val q: Queue<Node> = LinkedList()
    map[0][0][0] = 1
    q.offer(Node(0, 0, false))

    while (q.isNotEmpty()) {
        val target = q.poll()

        // 만약 벽을 무녀뜨렸다면 1, 무너뜨린 적이 없다면 0
        val wall = if (target.isWallRemove) 1 else 0

        if (target.x == n - 1 && target.y == m - 1) {
            println(map[target.x][target.y][wall])
            return
        }

        for (i in 0..<4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0..<n || ny !in 0..<m) continue

            if (map[nx][ny][0] == 0 && map[nx][ny][wall] == 0) {
                // 벽 아님
                map[nx][ny][wall] = map[target.x][target.y][wall] + 1
                q.offer(Node(nx, ny, target.isWallRemove))
            } else if (map[nx][ny][0] == -1 && !target.isWallRemove && map[nx][ny][1] == 0) {
                // 벽을 만남, 벽 부순적 없음(false - 0)
                map[nx][ny][1] = map[target.x][target.y][0] + 1
                q.offer(Node(nx, ny, true))
            }
        }
    }
    println(-1)
}