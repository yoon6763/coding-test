package baekjoon.gold.g5.숨바꼭질3

import java.util.Deque
import java.util.LinkedList

fun main() {
    val nk = readln().split(" ")
    val n = nk[0].toInt() // 내 위치
    val k = nk[1].toInt() // 목표 위치

    if (n == k) {
        println(0)
        return
    }

    val dq: Deque<Int> = LinkedList()
    dq.offer(n)

    val visited = Array(100001) { -1 }
    visited[n] = 0

    while (dq.isNotEmpty()) {
        val target = dq.pollFirst()

        val nx1 = target - 1
        val nx2 = target + 1
        val nx3 = target * 2

        if (nx3 in 0 until visited.size && visited[nx3] == -1) {
            dq.offerFirst(nx3)
            visited[nx3] = visited[target]
        }

        if (nx1 in 0 until visited.size && visited[nx1] == -1) {
            dq.offerLast(nx1)
            visited[nx1] = visited[target] + 1
        }

        if (nx2 in 0 until visited.size && visited[nx2] == -1) {
            dq.offerLast(nx2)
            visited[nx2] = visited[target] + 1
        }
        if(nx1 == k) {
            println(visited[nx1])
            return
        }
        if(nx2 == k) {
            println(visited[nx2])
            return
        }
        if(nx3 == k ){
            println(visited[nx3])
            return
        }
    }
}

/*
5 17 - 2
0 27 - 3
 */