package baekjoon.silver.s1

import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val st = StringTokenizer(readLine())
        val arr = Array(n) { st.nextToken().toInt() }.sorted()
        val deque = ArrayDeque<Int>()

        arr.forEachIndexed { index, i ->
            if (index % 2 == 0) deque.addFirst(i)
            else deque.addLast(i)
        }

        var ans = abs(deque.first() - deque.last())
        var cur = deque.removeFirst()
        while (deque.isNotEmpty()) {
            val next = deque.removeFirst()
            ans = maxOf(ans, abs(cur - next))
            cur = next
        }

        sb.appendLine(ans)
    }

    print(sb)
}