package goormlevel.lv3.`Stack`

import java.util.*
import kotlin.collections.ArrayDeque

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    val (n, size) = readLine().split(" ").map { it.toInt() }
    val stack = ArrayDeque<Int>()

    repeat(n) {
        val st = StringTokenizer(readLine())
        when (st.nextToken()) {
            "push" -> {
                if (stack.size == size) {
                    sb.append("Overflow\n")
                } else {
                    stack.addLast(st.nextToken().toInt())
                }
            }

            "pop" -> {
                if (stack.isEmpty()) {
                    sb.append("Underflow\n")
                } else {
                    sb.append("${stack.removeLast()}\n")
                }
            }
        }
    }

    println(sb)
}