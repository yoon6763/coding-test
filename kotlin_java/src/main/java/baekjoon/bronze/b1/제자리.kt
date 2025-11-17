package baekjoon.bronze.b1

import java.util.*

fun main() {
    readln()
    val q = ArrayDeque(readln().split(" ").map { it.toInt() })

    var now = 1
    var count = 0

    while (q.isNotEmpty()) {
        val x = q.removeFirst()
        if (x == now) {
            now++
        } else {
            count++
        }
    }

    println(count)
}
