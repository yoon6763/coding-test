package baekjoon.bronze.b3

import kotlin.math.pow

fun main() {
    val (a, b) = List(2) { readln() }
    print(2.0.pow((0..3).count { a[it] != b[it] }).toInt())
}