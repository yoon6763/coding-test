package baekjoon.silver.s3

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val bridgeCnt = readLine()!!.toInt()

    val map = Array(n + 1) { Array(n + 1) { false } }

    repeat(bridgeCnt) {
        val input = readLine()!!.split(" ")
        val x = input[0].toInt()
        val y = input[1].toInt()
        map[x][y] = true
        map[y][x] = true
    }

    bfs(n, map)
}

fun bfs(n: Int, map: Array<Array<Boolean>>) {

    val q: Queue<Int> = LinkedList()
    val visited = Array(n + 1) { false }
    visited[1] = true

    q.offer(1)

    var cnt = 0

    while (q.isNotEmpty()) {
        val target = q.poll()

        for(i in map.indices) {
            if(!visited[i] && map[target][i]) {
                q.offer(i)
                visited[i] = true
                cnt++
            }
        }
    }

    println(cnt)
}