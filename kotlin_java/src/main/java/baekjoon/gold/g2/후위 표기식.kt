package baekjoon.gold.g2

import java.util.Stack

fun main() {
    val input = readLine()!!
    val stack = Stack<Char>()
    val sb = StringBuilder()

    for (ch in input) {
        if(ch in 'A' .. 'Z') {
            sb.append(ch)
        } else {
            when (ch) {
                '+', '-', '/', '*' -> {
                    while (stack.isNotEmpty() && priority(stack.peek()) >= priority(ch)) {
                        sb.append(stack.pop())
                    }
                    stack.add(ch)
                }
                '(' -> stack.add(ch)
                ')' -> {
                    while (stack.isNotEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop())
                    }
                    stack.pop()
                }
            }
        }
    }

    while (stack.isNotEmpty()) sb.append(stack.pop())
    print(sb)
}

private fun priority(ch: Char) = when (ch) {
    '(', ')' -> 0
    '+', '-' -> 1
    '*', '/' -> 2
    else -> -1
}

// A*(B+C)