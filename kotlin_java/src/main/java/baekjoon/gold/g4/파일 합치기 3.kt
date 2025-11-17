package baekjoon.gold.g4

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val pq = PriorityQueue<Long>()
        readLine()
        pq.addAll(readLine().split(" ").map { it.toLong() })
        var sum = 0L
        while (true) {
            val temp = pq.poll() + pq.poll()
            pq.offer(temp)
            sum += temp
            if (pq.size == 1) break
        }
        sb.append(sum).append("\n")
    }
    print(sb)
}