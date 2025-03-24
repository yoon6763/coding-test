package baekjoon.silver.s5

import java.lang.StringBuilder
import java.util.LinkedList
import java.util.Queue

fun main() {
    val q = LinkedList<Int>() as Queue<Int>
    val n = readln().toInt()
    repeat(n) {
        q.offer(it + 1)
    }
    val sb = StringBuilder()
    while (q.isNotEmpty()) {
        sb.append(q.poll()).append(" ")
        if (q.isNotEmpty()) q.offer(q.poll())
    }
    println(sb)
}