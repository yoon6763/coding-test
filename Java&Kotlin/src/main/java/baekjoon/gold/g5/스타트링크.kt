package baekjoon.gold.g5.스타트링크

import java.util.LinkedList
import java.util.Queue

fun main() {
    // f - 건물의 층 개수
    // s - 시작 층
    // g - 목표 층
    // u - u 만큼 위로 이동
    // d - d 만큼 위로 이동
    val fsgud = readLine()!!.split(" ").map { it.toInt() }

    val n = fsgud[0]
    val now = fsgud[1]
    val goal = fsgud[2]
    val up = fsgud[3]
    val down = fsgud[4]

    val q = LinkedList<Int>() as Queue<Int>
    val visited = Array(n + 1) { -1 }
    q.offer(now)
    visited[now] = 0

    while (q.isNotEmpty()) {
        val oldFloor = q.poll()
        val uf = oldFloor + up
        val df = oldFloor - down

        if (oldFloor == goal) {
            println(visited[oldFloor])
            return
        }

        if (uf in 1..n && visited[uf] == -1) {
            visited[uf] = visited[oldFloor] + 1
            q.offer(uf)
        }

        if (df in 1..n && visited[df] == -1) {
            visited[df] = visited[oldFloor] + 1
            q.offer(df)
        }
    }
    println("use the stairs")
}