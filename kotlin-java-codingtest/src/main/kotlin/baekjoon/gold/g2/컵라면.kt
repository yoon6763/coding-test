package baekjoon.gold.g2

import java.util.*

data class Problem(val deadLine: Int, val cup: Long)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val problems = Array(n) { readLine().split(" ").let { Problem(it[0].toInt(), it[1].toLong()) } }
    problems.sortWith(compareBy({ it.deadLine }, { -it.cup }))

    val pq = PriorityQueue<Long>()

    problems.forEach {
        pq.add(it.cup)
        if (pq.size > it.deadLine) pq.poll()
    }

    println(pq.sum())
}