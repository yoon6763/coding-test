package baekjoon.platinum.p5.백조의호수

import java.util.*

data class Point(val x: Int, val y: Int)

var r = 0
var c = 0
val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)
val swans = Array<Point?>(2) { null }
val waterQueue = LinkedList<Point>() as Queue<Point>
var swanQueue = LinkedList<Point>() as Queue<Point>
lateinit var map: Array<Array<Char>>
lateinit var visited: Array<Array<Boolean>>

fun main() = with(System.`in`.bufferedReader()) {
    val rc = readLine().split(" ").map { it.toInt() }
    r = rc[0]
    c = rc[1]

    visited = Array(r) { Array(c) { false } }

    var day = 0

    var swanIdx = 0
    // L 백조, . 물, X 빙판
    map = Array(r) { x ->
        val line = readLine()
        Array(c) { y ->
            if (line[y] == 'L') {
                swans[swanIdx++] = Point(x, y)
                waterQueue.offer(Point(x, y))
            } else if (line[y] == '.') waterQueue.offer(Point(x, y))
            line[y]
        }
    }

    visited[swans[0]!!.x][swans[0]!!.y] = true
    swanQueue.offer(Point(swans[0]!!.x, swans[0]!!.y))

    while (!bfs()) {
        thaw()
        day++
    }

    println(day)
}


fun bfs(): Boolean {
    val nextQueue = LinkedList<Point>() as Queue<Point>

    while (swanQueue.isNotEmpty()) {
        val target = swanQueue.poll()

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until r || ny !in 0 until c || visited[nx][ny]) continue
            visited[nx][ny] = true

            if (nx == swans[1]!!.x && ny == swans[1]!!.y) return true
            else if (map[nx][ny] == 'X') nextQueue.offer(Point(nx, ny))
            else swanQueue.offer(Point(nx, ny))
        }
    }

    swanQueue = nextQueue
    return false
}

// 해빙
fun thaw() {
    val n = waterQueue.size

    repeat(n) {
        val target = waterQueue.poll()

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until r || ny !in 0 until c) continue
            if (map[nx][ny] == 'X') {
                map[nx][ny] = '.'
                waterQueue.offer(Point(nx, ny))
            }
        }
    }
}