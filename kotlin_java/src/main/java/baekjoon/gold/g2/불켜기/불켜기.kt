package baekjoon.gold.g2.불켜기

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)

var n = 0
var m = 0
var cnt = 1

lateinit var lightOnMap: Array<Array<Boolean>>
lateinit var switchMap: Array<Array<Queue<Node>>>

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    lightOnMap = Array(n) { Array(n) { false } }
    lightOnMap[0][0] = true

    switchMap = Array(n) { Array(n) { LinkedList() } }

    repeat(m) {
        val (switchRoomX, switchRoomY, lightRoomX, lightRoomY) = readLine().split(" ").map { it.toInt() - 1 }
        switchMap[switchRoomX][switchRoomY].add(Node(lightRoomX, lightRoomY))
    }

    bfs()

    println(cnt)
}

fun bfs() {
    val q = LinkedList<Node>() as Queue<Node>
    val visited = Array(n) { Array(n) { false } }
    visited[0][0] = true

    q.offer(Node(0, 0))

    var isLightOn = false

    while (q.isNotEmpty()) {
        val target = q.poll()

        while (switchMap[target.x][target.y].isNotEmpty()) {
            val lightOnRoom = switchMap[target.x][target.y].poll()
            if (!lightOnMap[lightOnRoom.x][lightOnRoom.y]) {
                isLightOn = true
                lightOnMap[lightOnRoom.x][lightOnRoom.y] = true
                cnt++
            }
        }

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until n || !lightOnMap[nx][ny] || visited[nx][ny]) continue

            q.offer(Node(nx, ny))
            visited[nx][ny] = true
        }
    }

    if(isLightOn) bfs()
}