package baekjoon.bronze.b4

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val (a, b) = readln().split(" ")

    val x1 = a[0] - 'a' + 1
    val y1 = a[1] - '0'

    val x2 = b[0] - 'a' + 1
    val y2 = b[1] - '0'

    println("${min(abs(x1 - x2), abs(y1 - y2))} ${max(abs(x1 - x2), abs(y1 - y2))}")
}
