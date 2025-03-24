package baekjoon.silver.s3

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, l) = readLine().split(" ").map(String::toInt)

    val pq = PriorityQueue<Double>()
    pq.addAll(readLine().split(" ").map { it.toDouble() })

    var ans = 0
    var len = 0.0

    while (pq.isNotEmpty()) {
        val e = pq.poll()

        if (e  > len) {
            len = e + l - 0.5
            ans++
        }
    }

    println(ans)
}