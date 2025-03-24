package baekjoon.bronze.b3

import kotlin.math.pow

fun main() =
    print(List(readln().toInt()) { readln().toInt() }.sumOf { (it / 10).toDouble().pow((it % 10).toDouble()).toInt() })