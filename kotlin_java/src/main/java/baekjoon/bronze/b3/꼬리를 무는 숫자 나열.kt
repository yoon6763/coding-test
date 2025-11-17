package baekjoon.bronze.b3

import kotlin.math.abs

fun main() {
    val (n1, n2) = readln().split(" ").map { it.toInt() - 1 }
    println(abs(n1 / 4 - n2 / 4) + abs(n1 % 4 - n2 % 4))
}