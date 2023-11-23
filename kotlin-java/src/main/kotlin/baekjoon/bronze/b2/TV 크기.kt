package baekjoon.bronze.b2

import kotlin.math.sqrt
fun main() {
    val (d, h, w) = readln().split(" ").map { it.toDouble() }
    val x = sqrt(d * d / (h * h + w * w))
    println("${(h * x).toInt()} ${(w * x).toInt()}")
}