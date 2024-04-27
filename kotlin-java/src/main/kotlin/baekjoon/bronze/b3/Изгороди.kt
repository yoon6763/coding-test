package baekjoon.bronze.b3

import kotlin.math.round

fun main() {
    val n = readln().toDouble()
    val a = readln().toDouble()
    println(round((180 - a) / 2 + a / 2).toInt())
}