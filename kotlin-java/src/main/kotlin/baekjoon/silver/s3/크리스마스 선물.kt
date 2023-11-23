package baekjoon.silver.s3

import java.lang.StringBuilder
import java.util.*

fun main() {
    val sb = StringBuilder()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    repeat(readln().toInt()) {
        val input = readln().trim().split(" ").map { it.toInt() }
        if (input[0] == 0) {
            if (pq.isEmpty()) sb.append("-1\n")
            else sb.append("${pq.poll()}\n")
        } else {
            for (i in 1..input[0]) pq.add(input[i])
        }
    }
    print(sb)
}