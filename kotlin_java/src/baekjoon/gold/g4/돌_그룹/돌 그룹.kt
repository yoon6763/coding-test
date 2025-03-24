package baekjoon.gold.g4.돌_그룹

import java.util.*

data class Node(val a: Int, val b: Int, val c: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (a, b, c) = readLine().split(" ").map { it.toInt() }

    if ((a + b + c) % 3 != 0) {
        println(0)
        return
    }

    val visited = Array(1501) { BooleanArray(1501) }

    val q = LinkedList<Node>() as Queue<Node>
    q.add(Node(a, b, c))
    visited[a][b] = true

    while (q.isNotEmpty()) {
        val (x, y, z) = q.poll()

        if (x == y && y == z) {
            println(1)
            return
        }

        if (x != y) {
            val nx = if (x > y) x - y else x + x
            val ny = if (x > y) y + y else y - x
            if (!visited[nx][ny]) {
                visited[nx][ny] = true
                q.add(Node(nx, ny, z))
            }
        }

        if (x != z) {
            val nx = if (x > z) x - z else x + x
            val nz = if (x > z) z + z else z - x
            if (!visited[nx][y]) {
                visited[nx][y] = true
                q.add(Node(nx, y, nz))
            }
        }

        if (y != z) {
            val ny = if (y > z) y - z else y + y
            val nz = if (y > z) z + z else z - y
            if (!visited[x][ny]) {
                visited[x][ny] = true
                q.add(Node(x, ny, nz))
            }
        }
    }

    println(0)
}