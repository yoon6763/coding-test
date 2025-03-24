package baekjoon.bronze.b4

import kotlin.math.min

fun main() {
    val chicken = readln().toInt()
    val (coke, beer) = readln().split(" ").map { it.toInt() }
    println(min(chicken, coke / 2 + beer))
}