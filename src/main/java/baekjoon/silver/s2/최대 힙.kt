package baekjoon.silver.s2

import java.util.Collections
import java.util.PriorityQueue

fun main() {
    val n = readLine()!!.toInt()

    val pq = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(n) {
        val num = readLine()!!.toInt()
        if (num == 0) {
            if (pq.isEmpty()) {
                println(0)
            } else {
                println(pq.poll())
            }
        } else {
            pq.offer(num)
        }
    }
}