package baekjoon.gold.g5.`항체 인식`

import java.util.LinkedList
import java.util.Queue

class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val beforeMap = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val afterMap = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    val q = LinkedList<Node>() as Queue<Node>
    val visited = Array(n) { BooleanArray(m) }
    var originColor = -1
    var changedColor = -1

    findStart@ for (i in 0..<n) {
        for (j in 0..<m) {
            if (beforeMap[i][j] != afterMap[i][j]) {
                q.offer(Node(i,j))
                visited[i][j] = true
                originColor = beforeMap[i][j]
                changedColor = afterMap[i][j]
                beforeMap[i][j] = changedColor
                break@findStart
            }
        }
    }

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0..<4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]
            if (nx !in 0..<n || ny !in 0..<m || beforeMap[nx][ny] != originColor || visited[nx][ny]) continue

            visited[nx][ny] = true
            beforeMap[nx][ny] = changedColor
            q.offer(Node(nx, ny))
        }
    }

    println(if (beforeMap.contentDeepEquals(afterMap)) "YES" else "NO")
}