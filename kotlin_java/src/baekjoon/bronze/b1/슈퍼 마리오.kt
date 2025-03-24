package baekjoon.bronze.b1

import kotlin.math.abs
fun main() {
    val sum = IntArray(10)
    for (i in 0 until 10) if (i == 0) sum[i] = readln().toInt() else sum[i] = sum[i - 1] + readln().toInt()
    println(sum.filter { abs(100 - it) == sum.minOf { abs(100 - it) } }.maxOrNull()!!)
}