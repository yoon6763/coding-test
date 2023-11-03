package baekjoon.gold.g1

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val (k, n) = readLine().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Long>()
    val st = StringTokenizer(readLine())

    val MAX_VALUE = 2L shl 30

    val arr = LongArray(k) {
        val num = st.nextToken().toLong()
        pq.offer(num)
        num
    }

    repeat(n - 1) {
        val cur = pq.poll()

        for (i in 0 until k) {
            val next = cur * arr[i]

            if (next > MAX_VALUE) break
            pq.offer(next)
            if (cur % arr[i] == 0L) break
        }
    }

    println(pq.poll())
}