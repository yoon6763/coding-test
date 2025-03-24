package baekjoon.silver.s4

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val queue = ArrayDeque<Int>()

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        when (st.nextToken().toInt()) {
            1 -> queue.addFirst(st.nextToken().toInt())
            2 -> queue.addLast(st.nextToken().toInt())
            3 -> sb.append("${if (queue.isEmpty()) -1 else queue.pollFirst()}").append("\n")
            4 -> sb.append("${if (queue.isEmpty()) -1 else queue.pollLast()}").append("\n")
            5 -> sb.append("${queue.size}").append("\n")
            6 -> sb.append("${if (queue.isEmpty()) 1 else 0}").append("\n")
            7 -> sb.append("${if (queue.isEmpty()) -1 else queue.peekFirst()}").append("\n")
            8 -> sb.append("${if (queue.isEmpty()) -1 else queue.peekLast()}").append("\n")
        }
    }

    print(sb)
}