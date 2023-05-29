package baekjoon.gold.g2.철로

import java.util.*

data class Rail(val start: Int, val end: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val rails = Array(n) {
        val st = StringTokenizer(readLine())
        val (a, b) = Array(2) { st.nextToken().toInt() }
        if (a < b) Rail(a, b) else Rail(b, a)
    }.sortedBy { it.end }

    val d = readLine().toInt()
    var result = 0

    val pq = PriorityQueue<Int>()

    rails.forEach { rail ->
        pq.offer(rail.start)

        while (pq.isNotEmpty() && pq.peek() < rail.end - d) {
            pq.poll()
        }

        result = maxOf(result, pq.size)
    }

    println(result)
}