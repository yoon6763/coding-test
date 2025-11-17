package baekjoon.gold.g5.`강의실`

import java.util.*

data class Lecture(var number: Int, var start: Int, var end: Int) : Comparable<Lecture> {
    override fun compareTo(other: Lecture): Int {
        return this.start - other.start
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val pq = PriorityQueue<Int>()
    val lectures = Array(n) {
        val st = StringTokenizer(readLine())
        Lecture(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
    }.sorted()

    var answer = 0

    lectures.forEach { lecture ->
        pq.offer(lecture.end)
        while (pq.isNotEmpty() && pq.peek() <= lecture.start) pq.poll()
        answer = maxOf(answer, pq.size)
    }
    println(answer)
}