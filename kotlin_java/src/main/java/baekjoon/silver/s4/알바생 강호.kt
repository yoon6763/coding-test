package baekjoon.silver.s4

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>(reverseOrder())

    repeat(n) {
        pq.add(readLine().toInt())
    }

    var ans = 0L
    repeat(n) {
        ans += maxOf(pq.poll() - it, 0)
    }

    println(ans)
}