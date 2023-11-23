package baekjoon.silver.s4

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    var cnt = 0

    repeat(readLine().toInt()) {
        val string = readLine()
        val stack = Stack<Char>()

        for (ch in string) {
            if (stack.isNotEmpty() && stack.peek() == ch) stack.pop()
            else stack.add(ch)
        }

        if (stack.isEmpty()) cnt++
    }
    println(cnt)
}