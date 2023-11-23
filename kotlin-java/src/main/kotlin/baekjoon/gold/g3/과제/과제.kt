package baekjoon.gold.g3.과제

import java.util.*

data class Homework(val day: Int, val score: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val pq = PriorityQueue<Homework>(compareBy { -it.score })

    repeat(n) {
        val st = StringTokenizer(readLine())
        pq.add(Homework(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    var answer = 0

    val visited = Array(pq.maxOf { it.day } + 1) { false }

    while (pq.isNotEmpty()) {
        val target = pq.poll()

        var day = target.day

        while (day > 0) {
            if (!visited[day]) {
                visited[day] = true
                answer += target.score
                break
            }
            day--
        }
    }

    println(answer)
}