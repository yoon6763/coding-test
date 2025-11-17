package baekjoon.silver.s1.`죽음의 등굣길`

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = List(2) { readLine().toInt() }
    val map = Array(n) { readLine().split(" ").map { it.toInt() } }
    val x = readLine().toInt()

    val accessPoints = ArrayList<Node>()
    repeat(n) { i ->
        repeat(m) { j ->
            if (map[i][j] == map[0][0]) accessPoints.add(Node(i, j))
        }
    }

    val visited = Array(n) { BooleanArray(m) }

    val q = LinkedList<Node>() as Queue<Node>
    visited[0][0] = true
    q.add(Node(0, 0))

    while (q.isNotEmpty()) {
        val cur = q.poll()

        accessPoints.forEach { next ->
            if (visited[next.x][next.y] || abs(next.x - cur.x) + abs(next.y - cur.y) > x) return@forEach
            visited[next.x][next.y] = true

            if (next.x == n - 1 && next.y == m - 1) {
                println("ALIVE")
                return
            }

            q.add(next)
        }
    }

    println("DEAD")
}