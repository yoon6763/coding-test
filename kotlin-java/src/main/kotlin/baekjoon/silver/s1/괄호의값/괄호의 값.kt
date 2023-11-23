package baekjoon.silver.s1.괄호의값

import kotlin.system.exitProcess

var ans = 0
var group = 1

fun main() {
    val line = readln()
    val stack = ArrayDeque<Char>()

    for (i in line.indices) {
        when (val ch = line[i]) {
            '(' -> {
                stack.addLast(ch)
                group *= 2
            }

            '[' -> {
                stack.addLast(ch)
                group *= 3
            }

            ')' -> {
                if (stack.isEmpty() || stack.last() != '(') exception()
                stack.removeLast()
                if (line[i - 1] == '(') ans += group
                group /= 2
            }

            ']' -> {
                if (stack.isEmpty() || stack.last() != '[') exception()
                stack.removeLast()
                if (line[i - 1] == '[') ans += group
                group /= 3
            }
        }
    }
    if (stack.isNotEmpty()) exception()
    println(ans)
}

fun exception() {
    println(0)
    exitProcess(0)
}

