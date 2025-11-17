package baekjoon.silver.s1.`버섯 농장`

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    var (n, restSpore, k) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().split(" ").map { it.toInt() } }

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    val visited = Array(n) { BooleanArray(n) }
    val q = LinkedList<Node>() as Queue<Node>
    var flag = false
    for (i in 0..<n) {
        for (j in 0..<n) {
            if (map[i][j] == 1 || visited[i][j]) continue
            flag = true
            q.clear()
            q.add(Node(i, j))
            visited[i][j] = true

            var size = 1
            while (q.isNotEmpty()) {
                val cur = q.poll()
                for (d in 0..<4) {
                    val nx = cur.x + dx[d]
                    val ny = cur.y + dy[d]
                    if (nx !in 0..<n || ny !in 0..<n || map[nx][ny] == 1 || visited[nx][ny]) continue
                    q.add(Node(nx, ny))
                    visited[nx][ny] = true
                    size++
                }
            }

            restSpore -= size / k + if (size % k != 0) 1 else 0
        }
    }

    if (restSpore < 0 || !flag) {
        println("IMPOSSIBLE")
    } else {
        println("POSSIBLE")
        println(restSpore)
    }
}