package baekjoon.gold.g4.`불!`

import java.util.LinkedList
import java.util.Queue

data class Node(var x: Int, var y: Int)

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(1, -1, 0, 0)

    val (n, m) = readLine().split(" ").map { it.toInt() }

    // 불과 지훈이의 큐와 맵
    val q: Queue<Node> = LinkedList()
    val fireQueue: Queue<Node> = LinkedList()
    val map = Array(n) { Array(m) { 0 } }
    val fireMap = Array(n) { Array(m) { 0 } }

    repeat(n) { x ->
        val line = readLine()
        repeat(m) { y ->
            when (line[y]) {
                '#' -> {
                    map[x][y] = -1 // 벽
                    fireMap[x][y] = -1
                }
                '.' -> {
                    map[x][y] = 0 // 길
                }
                'F' -> {
                    fireMap[x][y] = 1 // 불
                    fireQueue.offer(Node(x, y))
                }
                else -> {
                    q.offer(Node(x, y))
                    map[x][y] = 1
                    if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
                        println(1)
                        return
                    }
                }
            }
        }
    }

    // 불을 확산시킴
    while (fireQueue.isNotEmpty()) {
        val target = fireQueue.poll()

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || fireMap[nx][ny] != 0) {
                continue
            }

            fireMap[nx][ny] = fireMap[target.x][target.y] + 1
            fireQueue.offer(Node(nx, ny))
        }
    }

    // 지훈이를 탈출시키기 위한 큐
    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            // 불이 확산되기 전에 지훈이가 해당 좌표에 도달할 수 있는 가
            // -> fireMap[nx][ny] <= map[target.x][target.y] + 1
            if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] != 0 || (fireMap[nx][ny] != 0 && fireMap[nx][ny] <= map[target.x][target.y] + 1)) {
                continue
            }

            // 탈출 시 도달 시간 출력 후 프로그램 종료
            if (nx == 0 || nx == n - 1 || ny == 0 || ny == m - 1) {
                println(map[target.x][target.y] + 1)
                return
            }
            map[nx][ny] = map[target.x][target.y] + 1
            q.offer(Node(nx, ny))
        }
    }

    // BFS가 완전히 종료될때까지 프로그램이 살아있으면 탈출 불가 (탈출하면 return으로 프로그램을 종료시킴)
    println("IMPOSSIBLE")
}
