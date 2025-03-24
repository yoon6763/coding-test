package baekjoon.bronze.b1

import java.util.*

fun main() = repeat(readln().toInt()) {
    readln()
    readln()
    val sejun = PriorityQueue(readln().split(" ").map { it.toInt() })
    val sebi = PriorityQueue(readln().split(" ").map { it.toInt() })
    while (sejun.isNotEmpty() && sebi.isNotEmpty()) if (sejun.peek() < sebi.peek()) sejun.poll() else sebi.poll()
    println(if (sejun.isEmpty()) "B" else "S")
}