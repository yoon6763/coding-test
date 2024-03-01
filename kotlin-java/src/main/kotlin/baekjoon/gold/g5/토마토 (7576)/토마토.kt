package baekjoon.gold.g5.`토마토 (7576)`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

data class Node(val x: Int, val y: Int)

var n = 0
var m = 0

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val mn = br.readLine()!!.split(" ") // m, n 순으로 입력받음
    val n = mn[1].toInt()
    val m = mn[0].toInt()

    var day = 0

    val map = Array(n) { Array(m) { 0 } }

    val startNodes: Queue<Node> = LinkedList()

    repeat(n) { x ->
        val st = StringTokenizer(br.readLine(), " ")
        repeat(m) { y ->
            map[x][y] = st.nextToken().toInt()
            if (map[x][y] == 1) {
                startNodes.offer(Node(x, y))
            }
        }
    }

    val q: Queue<Node> = LinkedList()
    startNodes.forEach { q.offer(it) }

    q.offer(Node(-1, -1))


    while (q.isNotEmpty()) {
        val target = q.poll()

        if (target.x == -1 && target.y == -1) {
            day++
            if (q.isNotEmpty()) {
                q.offer(Node(-1, -1))
            }
        }

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == 1 || map[nx][ny] == -1)
                continue

            map[nx][ny] = 1
            q.offer(Node(nx, ny))
        }
    }

    map.forEach { it ->
        it.forEach { it2 ->
            if (it2 == 0) {
                println(-1)
                return
            }
        }
    }

    println(day - 1)
}