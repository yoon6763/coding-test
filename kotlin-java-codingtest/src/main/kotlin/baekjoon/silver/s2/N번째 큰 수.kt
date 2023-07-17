package baekjoon.silver.s2

import java.util.Collections
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(n) {
        val st = StringTokenizer(readLine())
        repeat(n) {
            pq.offer(st.nextToken().toInt())
        }
    }

    repeat(n - 1) {
        pq.poll()
    }
    println(pq.poll())
}