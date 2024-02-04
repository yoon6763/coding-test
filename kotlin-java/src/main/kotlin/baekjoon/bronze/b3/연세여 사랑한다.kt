package baekjoon.bronze.b3

import kotlin.math.abs

fun main() {
    val s = readln()
    println((abs((s[0].code - "I"[0].code).toDouble()).toInt() + 84))
}
