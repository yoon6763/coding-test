package baekjoon.silver.s4

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val stack = Stack<Int>()

    val sb = StringBuilder()

    repeat(n) {
        val st = StringTokenizer(readLine())
        when (st.nextToken().toInt()) {
            1 -> stack.push(st.nextToken().toInt())
            2 -> sb.append("${if (stack.isEmpty()) -1 else stack.pop()}").append("\n")
            3 -> sb.append("${stack.size}").append("\n")
            4 -> sb.append("${if (stack.isEmpty()) 1 else 0}").append("\n")
            5 -> sb.append("${if (stack.isEmpty()) -1 else stack.peek()}").append("\n")
        }
    }

    print(sb)
}