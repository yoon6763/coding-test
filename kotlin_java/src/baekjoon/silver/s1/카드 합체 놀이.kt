package baekjoon.silver.s1

import java.util.PriorityQueue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Long>()
    pq.addAll(readln().split(" ").map { it.toLong() })

    repeat(m) {
        val sum = pq.poll() + pq.poll()
        pq.add(sum)
        pq.add(sum)
    }

    println(pq.sum())
}