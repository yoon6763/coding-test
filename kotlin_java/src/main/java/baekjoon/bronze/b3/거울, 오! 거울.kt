package baekjoon.bronze.b3

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while (true) {
        val line = readLine()
        if (line == "***") break
        sb.append(line.reversed()).append("\n")
    }

    print(sb)
}