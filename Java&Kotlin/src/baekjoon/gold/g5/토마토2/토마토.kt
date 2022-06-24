package baekjoon.gold.g5.토마토2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

data class Node(val x: Int, val y: Int, val z: Int)


val dx = arrayOf(0, 0, 1, -1, 0, 0)
val dy = arrayOf(1, -1, 0, 0, 0, 0)
val dz = arrayOf(0, 0, 0, 0, 1, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val mn = br.readLine()!!.split(" ") // m, n 순으로 입력받음
    val n = mn[1].toInt()
    val m = mn[0].toInt()
    val h = mn[2].toInt()

    var day = 0

    val map = Array(n) { Array(m) { Array(h) { 0 } } }

    val startNodes: Queue<Node> = LinkedList()

    repeat(h) { z ->
        repeat(n) { x ->
            val st = StringTokenizer(br.readLine(), " ")
            repeat(m) { y ->

                map[x][y][z] = st.nextToken().toInt()
                if (map[x][y][z] == 1) {
                    startNodes.offer(Node(x, y, z))
                }
            }
        }
    }

    val q: Queue<Node> = LinkedList()
    startNodes.forEach { q.offer(it) }

    q.offer(Node(-1, -1, -1))


    while (q.isNotEmpty()) {
        val target = q.poll()

        if (target.x == -1 && target.y == -1 && target.z == -1) {
            day++
            if (q.isNotEmpty()) {
                q.offer(Node(-1, -1, -1))
            }
        }

        for (i in 0 until 6) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]
            val nz = target.z + dz[i]

            if (nx !in 0 until n || ny !in 0 until m || nz !in 0 until h || map[nx][ny][nz] == 1 || map[nx][ny][nz] == -1)
                continue

            map[nx][ny][nz] = 1
            q.offer(Node(nx, ny, nz))
        }
    }

    map.forEach { it ->
        it.forEach { it2 ->
            it2.forEach { it3 ->
                if (it3 == 0) {
                    println(-1)
                    return
                }
            }
        }
    }

    println(day - 1)
}