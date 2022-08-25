package baekjoon.bronze.b5

import kotlin.math.abs

fun main() {
    val line = readLine()!!.split(" ")
    println(abs(line[0].toLong() - line[1].toLong()))
}