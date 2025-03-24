package baekjoon.gold.g1.`수영장 만들기`

import java.util.*

var n = 0
var m = 0
val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, -1, 0, 1)

lateinit var map: Array<IntArray>

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ")
    n = nm[0].toInt()
    m = nm[1].toInt()

    map = Array(n) {
        val line = readLine()
        IntArray(m) { line[it].digitToInt() }
    }

    var waterWeight = 0

    for (h in 2..9) {
        for (i in 0 until n) {
            for (j in 0 until m) {
                waterWeight += bfs(i, j, h)
            }
        }
    }

    println(waterWeight)
}

fun bfs(x: Int, y: Int, height: Int): Int {
    if (map[x][y] >= height) return 0

    var cnt = height - map[x][y]
    map[x][y] = height

    val q = LinkedList<Node>() as Queue<Node>
    q.offer(Node(x, y))

    var flag = true

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m) {
                flag = false
                continue
            }

            if (map[nx][ny] >= height) continue

            cnt += height - map[nx][ny]
            map[nx][ny] = height
            q.offer(Node(nx, ny))
        }
    }

    return if (flag) cnt else 0
}