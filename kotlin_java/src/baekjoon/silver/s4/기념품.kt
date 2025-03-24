package baekjoon.silver.s4

import kotlin.collections.ArrayDeque
import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val q = ArrayDeque<Int>()
    q.addAll(1..n)

    var index = 1
    while (q.size > 1) {
        val pow = (index.toDouble().pow(3.0) - 1).toLong() % q.size

        for (i in 0 until pow) q.add(q.removeFirst())

        q.removeFirst()
        index++
    }

    println(q.removeFirst())
}