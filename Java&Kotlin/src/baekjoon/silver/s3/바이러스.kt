package baekjoon.silver.s3

import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readLine()!!.toInt()
    val bridgeCnt = readLine()!!.toInt()

    val bridge = Array(bridgeCnt) { Array(2) { 0 } }

    repeat(bridgeCnt) {
        val input = readLine()!!.split(" ")
        bridge[it][0] = input[0].toInt() -1
        bridge[it][1] = input[1].toInt() - 1
    }

    bridge.sortBy { it[0] }

    bfs(n, bridge)
}

fun bfs(n: Int, bridge: Array<Array<Int>>) {

    val q: Queue<Int> = LinkedList()
    val visited = Array(n) { false }
    visited[0] = true

    q.offer(bridge[0][0])

    var cnt = 0

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (b in bridge.filter { it[0] == target }) {
            if (!visited[b[1]]) {
                q.offer(b[1])
                visited[b[1]] = true
                cnt++
            }
        }
    }

    println(cnt)
}