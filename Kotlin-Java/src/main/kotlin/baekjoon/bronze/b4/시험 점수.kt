package baekjoon.bronze.b4

import kotlin.math.max
fun main() = println(max(readln().split(" ").sumOf { it.toInt() }, readln().split(" ").sumOf { it.toInt() }))