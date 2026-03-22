package baekjoon.bronze.b3

import kotlin.math.PI

fun main() {
    val (w, h) = readln().split(" ").map { it.toDouble() }
    val r = readln().toDouble()
    println(w * h - (PI * r * r / 4.0))
}