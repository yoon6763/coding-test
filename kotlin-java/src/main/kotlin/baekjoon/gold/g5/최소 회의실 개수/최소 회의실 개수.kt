package baekjoon.gold.g5.`최소 회의실 개수`

import java.util.PriorityQueue

data class Meet(val start: Int, val end: Int)

fun main() {
    val n = readln().toInt()

    val meets = Array(n) {
        val (s, e) = readln().split(" ").map { it.toInt() }
        Meet(s, e)
    }.sortedBy { it.start }

    var cnt = 0
    val pq = PriorityQueue<Int>()

    meets.forEach { meet ->
        pq.offer(meet.end)
        while (pq.isNotEmpty() && pq.peek() <= meet.start) pq.poll()
        cnt = maxOf(cnt, pq.size)
    }
    println(cnt)
}