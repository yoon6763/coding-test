package baekjoon.silver.s1.출근

import java.util.*

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val map = Array(n) { readLine().split(" ").map { it.toInt() } }
    val visited = Array(n) { IntArray(m) { -1 } }
    val queue = LinkedList<Node>() as Queue<Node>

    repeat(m) {
        if (map[0][it] == 1) {
            queue.add(Node(0, it))
            visited[0][it] = 0
        }
    }

    val d = readLine().toInt()
    val dx = Array(d) { 0 }
    val dy = Array(d) { 0 }
    repeat(d) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        dx[it] = x
        dy[it] = y
    }

    while (queue.isNotEmpty()) {
        val target = queue.poll()

        for (i in 0 until d) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == 0 || visited[nx][ny] != -1) continue
            visited[nx][ny] = visited[target.x][target.y] + 1
            queue.add(Node(nx, ny))

            if (nx == n - 1) {
                println(visited[nx][ny])
                return
            }
        }
    }

    println(-1)
}