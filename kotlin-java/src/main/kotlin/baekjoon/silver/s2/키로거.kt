package baekjoon.silver.s2

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val cmd = readLine()
        val list = LinkedList<Char>()
        var ptr = 0

        for (c in cmd) {
            when (c) {
                '<' -> ptr--
                '>' -> ptr++
                '-' -> if (list.isNotEmpty() && ptr != 0) list.removeAt(ptr-- - 1)
                else -> list.add(ptr++, c)
            }
            if (ptr > list.size) ptr = list.size
            if (ptr < 0) ptr = 0
        }

        sb.append(list.joinToString("")).append("\n")
    }
    print(sb)
}