package baekjoon.platinum.p5

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val text = readLine()
    val pattern = readLine()

    val table = IntArray(pattern.length)

    var j = 0
    for (i in 1 until pattern.length) {
        while (j > 0 && pattern[i] != pattern[j]) {
            j = table[j - 1]
        }
        if (pattern[i] == pattern[j]) {
            table[i] = ++j
        }
    }

    var count = 0
    val sb = StringBuilder()
    j = 0

    for (i in text.indices) {
        while (j > 0 && text[i] != pattern[j]) {
            j = table[j - 1]
        }
        if (text[i] == pattern[j]) {
            if (j == pattern.length - 1) {
                count++
                sb.append(i - pattern.length + 2).append("\n")
                j = table[j]
            } else {
                j++
            }
        }
    }

    println(count)
    println(sb)
}