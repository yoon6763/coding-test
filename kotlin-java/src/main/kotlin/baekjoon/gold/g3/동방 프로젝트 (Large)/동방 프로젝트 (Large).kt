package baekjoon.gold.g3.`동방 프로젝트 (Large)`

import java.util.*

data class Room(val start: Int, val end: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val q = PriorityQueue<Room> { a, b -> a.start - b.start }

    var startIdx = 987654321
    var endIdx = 0

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val (start, end) = List(2) { st.nextToken().toInt() }
        if (start < end) {
            q.offer(Room(start, end))
            startIdx = minOf(startIdx, start)
            endIdx = maxOf(endIdx, end)
        }
    }

    if (q.isEmpty()) {
        println(n)
        return
    }

    var cnt = 0

    while (q.isNotEmpty()) {
        val cur = q.poll()

        if (q.isNotEmpty()) {
            if (cur.end >= q.peek().start) {
                q.offer(Room(cur.start, maxOf(cur.end, q.poll().end)))
            } else {
                cnt += q.peek().start - cur.end
            }
        }
    }

    println(startIdx + cnt + n - endIdx)
}