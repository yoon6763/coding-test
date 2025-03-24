package baekjoon.gold.g4.치즈

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

var n = 0
var m = 0

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

lateinit var map: Array<Array<Int>>

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { readLine().split(" ").map { it.toInt() }.toTypedArray() }

    var cheese = 0
    var time = -1

    while (true) {
        time++
        val nowCheese = bfs()
        if (nowCheese == 0) break
        cheese = nowCheese
    }

    println(time)
    println(cheese)
}

fun bfs(): Int {
    val visited = Array(n) { BooleanArray(m) }
    visited[0][0] = true

    val q = LinkedList<Node>() as Queue<Node>
    q.offer(Node(0, 0))

    var cheeseCnt = 0

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny]) continue
            visited[nx][ny] = true

            if (map[nx][ny] == 1) {
                cheeseCnt++
                continue
            }
            q.offer(Node(nx, ny))
        }
    }

    repeat(n) { x ->
        repeat(m) { y ->
            if (visited[x][y] && map[x][y] == 1) map[x][y] = 0
        }
    }

    return cheeseCnt
}