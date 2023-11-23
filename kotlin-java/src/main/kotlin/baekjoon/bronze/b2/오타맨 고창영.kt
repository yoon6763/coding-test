package baekjoon.bronze.b2

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val line = readLine().split(" ")
        val removeIdx = line[0].toInt() - 1
        val str = line[1]
        sb.append(str.removeRange(removeIdx, removeIdx + 1)).append("\n")
    }
    print(sb)
}