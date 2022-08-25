package baekjoon.silver.s1.숨바꼭질

import java.util.LinkedList
import java.util.Queue

fun main() {
    val nk = readLine()!!.split(" ")
    var n = nk[0].toInt() // 내 위치
    val k = nk[1].toInt() // 목표 위치

    if(n == k ){
        println(0)
        return
    }

    val q: Queue<Int> = LinkedList()
    q.offer(n)

    val visited = Array(100001) { -1 }
    visited[n] = 0

    while (q.isNotEmpty()) {
        val target = q.poll()

        val nx1 = target + 1
        val nx2 = target - 1
        val nx3 = target * 2

        if (nx1 == k || nx2 == k || nx3 == k) {
            println(visited[target] + 1)
            return
        }

        if (nx1 in 0 until visited.size && visited[nx1] == -1) {
            q.offer(nx1)
            visited[nx1] = visited[target] + 1
        }

        if (nx2 in 0 until visited.size && visited[nx2] == -1) {
            q.offer(nx2)
            visited[nx2] = visited[target] + 1
        }

        if (nx3 in 0 until visited.size && visited[nx3] == -1) {
            q.offer(nx3)
            visited[nx3] = visited[target] + 1
        }
    }
}