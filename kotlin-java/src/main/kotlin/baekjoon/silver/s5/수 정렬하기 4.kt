package baekjoon.silver.s5

import java.util.Collections
import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(n) {
        pq.add(readLine().toInt())
    }

    val sb = StringBuilder()

    while (pq.isNotEmpty()) {
        sb.append("${pq.poll()}\n")
    }
    print(sb)

}