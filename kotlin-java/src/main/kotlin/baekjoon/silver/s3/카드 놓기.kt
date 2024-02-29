package baekjoon.silver.s3

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine().reversed())
    val deque = ArrayDeque<Int>()

    for (i in 1..n) {
        when (st.nextToken().toInt()) {
            1 -> deque.addFirst(i)

            2 -> {
                val top = deque.removeFirst()
                deque.addFirst(i)
                deque.addFirst(top)
            }

            else -> deque.addLast(i)
        }
    }

    println(deque.joinToString(" "))
}