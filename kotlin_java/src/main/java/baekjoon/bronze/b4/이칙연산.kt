package baekjoon.bronze.b4

import kotlin.math.max

fun main() {
    val n = readLine()!!.split(" ").map { it.toInt() }
    val r1 = n[0].toDouble() / n[1] * n[2]
    val r2 = n[0].toDouble() * n[1] / n[2]

    println(max(r1,r2).toInt())
}