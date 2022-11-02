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

        // 큐에서 꺼낸게 목표 층일때 종료
        if (oldFloor == goal) {
            println(visited[oldFloor])
            return
        }

        // 위 층으로 이동
        if (uf in 1..n && visited[uf] == -1) {
            visited[uf] = visited[oldFloor] + 1
            q.offer(uf)
        }

        // 아래 층으로 이동
        if (df in 1..n && visited[df] == -1) {
            visited[df] = visited[oldFloor] + 1
            q.offer(df)
        }
    }

    // 큐가 다 빌때까지 찾지 못하면 갈 수 없는 경로
    println("use the stairs")
}