package baekjoon.gold.g3.`움직이는 미로 탈출`

import java.util.*

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = 8
    val map = Array(n) { readLine().toCharArray() }
    val dx = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1, 0)
    val dy = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1, 0)

    val q = LinkedList<Node>() as Queue<Node>
    q.add(Node(7, 0))

    while (q.isNotEmpty()) {
        val visited = Array(n) { BooleanArray(n) }

        for (i in 0..<q.size) {
            val target = q.poll()
            if (map[target.x][target.y] == '#') continue
            if (target.x == 0 && target.y == 7) {
                println(1)
                return
            }

            for (j in 0..<9) {
                val nx = target.x + dx[j]
                val ny = target.y + dy[j]
                if (nx !in 0..<n || ny !in 0..<n || map[nx][ny] == '#' || visited[nx][ny]) continue
                visited[nx][ny] = true
                q.add(Node(nx, ny))
            }
        }

        wallDown(map)
    }

    println(0)
}

fun wallDown(map: Array<CharArray>) {
    for (i in map.size - 1 downTo 1) {
        for (j in map[i].indices) {
            map[i][j] = map[i - 1][j]
        }
    }
    map[0] = CharArray(map[0].size) { '.' }
}