package baekjoon.silver.s5

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    var dasom = readLine().toInt()

    repeat(n - 1) {
        pq.add(readLine().toInt())
    }

    var cnt = 0
    while (pq.isNotEmpty() && pq.peek() >= dasom) {
        dasom++
        cnt++
        pq.add(pq.poll() - 1)
    }

    println(cnt)
}