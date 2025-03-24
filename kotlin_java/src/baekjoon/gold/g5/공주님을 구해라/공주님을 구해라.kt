package baekjoon.gold.g5.`공주님을 구해라`

import java.util.*
import kotlin.math.abs

data class Node(var x: Int, var y: Int)

var n = 0
var m = 0
var t = 0

val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(1, 0, -1, 0)

lateinit var map: Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {
    val nmt = readLine().split(" ").map { it.toInt() }
    n = nmt[0]
    m = nmt[1]
    t = nmt[2]

    val sword = Node(0, 0)

    map = Array(n) { x ->
        val st = StringTokenizer(readLine())

        IntArray(m) { y ->
            val num = st.nextToken().toInt()
            if (num == 2) {
                sword.x = x
                sword.y = y
            }
            num
        }
    }

    val getSword = bfs(Node(0, 0), sword) + abs(sword.x - n + 1) + abs(sword.y - m + 1)
    val getPrincess = bfs(Node(0, 0), Node(n - 1, m - 1))

    val distance = minOf(getSword, getPrincess)
    println(if (distance <= t) distance else "Fail")
}

fun bfs(start: Node, end: Node): Int {
    val queue = ArrayDeque<Node>()
    val visited = Array(n) { IntArray(m) }
    visited[start.x][start.y] = 1
    queue.add(start)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()

        for (i in 0..<4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] == 1 || visited[nx][ny] != 0) continue
            visited[nx][ny] = visited[x][y] + 1
            queue.addLast(Node(nx, ny))

            if (nx == end.x && ny == end.y) return visited[nx][ny] - 1
        }
    }

    return 987654321
}