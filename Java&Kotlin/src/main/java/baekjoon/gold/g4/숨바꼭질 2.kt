package baekjoon.gold.g4.숨바꼭질2

import java.util.*

fun main() {
    val nk = readLine()!!.split(" ")
    val n = nk[0].toInt() // 내 위치
    val k = nk[1].toInt() // 목표 위치
    val MAX_POINT = 100000

    if (n >= k) {
        println(n - k)
        println(1)
        return
    }

    val q: Queue<Int> = LinkedList()
    q.offer(n)

    val visited = Array(MAX_POINT + 1) { 0 }
    visited[n] = 1

    var cnt = 0
    var minTime = 987654321

    while (q.isNotEmpty()) {
        val oldPoint = q.poll()

        if (minTime < visited[oldPoint]) break

        for (newPoint in intArrayOf(oldPoint + 1, oldPoint - 1, oldPoint * 2)) {
            if (newPoint !in 0 .. MAX_POINT) continue

            if (newPoint == k) {
                minTime = visited[oldPoint]
                cnt++
            }

            if (visited[newPoint] == 0 || visited[newPoint] == visited[oldPoint] + 1) {
                q.offer(newPoint)
                visited[newPoint] = visited[oldPoint] + 1
            }
        }
    }
    println(minTime)
    println(cnt)
}