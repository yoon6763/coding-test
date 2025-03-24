package baekjoon.silver.s1.그림

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val q = LinkedList<Node>() as Queue<Node>

    var max = 0
    var cnt = 0

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    repeat(n) { x ->
        repeat(m) { y ->
            if (map[x][y] == 1) {
                map[x][y] = 0
                cnt++
                var groupCnt = 1
                q.offer(Node(x, y))

                while (q.isNotEmpty()) {
                    val target = q.poll()

                    for (i in 0 until 4) {
                        val nx = target.x + dx[i]
                        val ny = target.y + dy[i]

                        if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == 0) continue

                        map[nx][ny] = 0
                        groupCnt++
                        q.offer(Node(nx, ny))
                    }
                }

                max = maxOf(max, groupCnt)
            }
        }
    }

    println(cnt)
    println(max)
}