package baekjoon.gold.g5

import java.util.PriorityQueue
import java.util.StringTokenizer

data class Lecture(val start: Int, val end: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val lectures = Array(n) {
        val st = StringTokenizer(readLine())
        Lecture(st.nextToken().toInt(), st.nextToken().toInt())
    }.sortedWith(compareBy({ it.start }, { it.end }))

    var result = 0
    val pq = PriorityQueue<Int>()

    lectures.forEach { lecture ->
        pq.offer(lecture.end)

        while (pq.isNotEmpty() && pq.peek() <= lecture.start) {
            pq.poll()
        }

        result = maxOf(result, pq.size)
    }

    println(result)
}