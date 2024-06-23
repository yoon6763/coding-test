package baekjoon.bronze.b3

import kotlin.math.sqrt

fun main() = repeat(readln().toInt()) {
    val (a, b, c) = readln().split(" ").map { it.toDouble() }
    val topRight = b * b - 4 * a * c
    val up = (-b + sqrt(topRight)) / (2 * a)
    val down = (-b - sqrt(topRight)) / (2 * a)
    println("%.3f, %.3f".format(up, down))
}