package baekjoon.silver.s4

import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().toInt()
    val q = LinkedList<Int>() as Queue<Int>
    while (true) {
        val input = readln().toInt()
        if (input == -1) break
        if (input == 0 && q.isNotEmpty()) q.poll()
        else if (q.size < n) q.offer(input)
    }
    println(if (q.isEmpty()) "empty" else q.joinToString(" "))
}