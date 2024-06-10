package baekjoon.gold.g4

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(readLine())

    val lower = PriorityQueue<Int>(Collections.reverseOrder())
    val upper = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(n) {
        st.nextToken().toInt().let { if (it > 0) upper.add(it) else lower.add(-it) }
    }

    val solve = { pq: PriorityQueue<Int> ->
        var result = 0
        while (pq.isNotEmpty()) {
            result += pq.poll() * 2
            repeat(m - 1) {
                if (pq.isNotEmpty()) pq.poll()
            }
        }
        result
    }

    println(-maxOf(lower.peek() ?: 0, upper.peek() ?: 0) + solve(lower) + solve(upper))
}