package baekjoon.bronze.b4

import kotlin.math.pow

fun main() {
    while (true) {
        val a = readln().toDouble()
        if (a == 0.0) break
        println("%.2f".format(1 + a + a.pow(2) + a.pow(3) + a.pow(4)))
    }
}