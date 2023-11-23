package baekjoon.silver.s4

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        var line = readLine()
        if (line == ".") break
        // 괄호만 남기기
        line = line.filter { it in "([)]" }

        val stack = Stack<Char>()

        for (i in line) {
            when (i) {
                '(', '[' -> stack.add(i)
                ')' -> if (stack.isNotEmpty() && stack.peek() == '(') stack.pop() else stack.add(i)
                ']' -> if (stack.isNotEmpty() && stack.peek() == '[') stack.pop() else stack.add(i)
            }
        }

        sb.append(if (stack.isEmpty()) "yes" else "no").append("\n")
    }

    print(sb)
}