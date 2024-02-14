package baekjoon.bronze.b4

import kotlin.math.PI

fun main() = repeat(readln().toInt()) {
    val (A, P1) = readln().split(" ").map { it.toDouble() }
    val (R, P2) = readln().split(" ").map { it.toDouble() }
    println(if ((A / P1) > ((PI * R * R) / P2)) "Slice of pizza" else "Whole pizza")
}

