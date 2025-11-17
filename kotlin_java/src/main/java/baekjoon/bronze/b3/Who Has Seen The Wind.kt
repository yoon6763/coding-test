package baekjoon.bronze.b3

import kotlin.math.pow

fun main() {
    val h = readln().toInt()
    val m = readln().toInt()
    var t = 1.0

    while (t <= m) {
        val a = ((-6) * (t.pow(4))) + (h * (t.pow(3))) + (2 * (t.pow(2))) + t
        if (a <= 0) {
            println("The balloon first touches ground at hour: ${t.toInt()}")
            return
        }
        t++
    }

    println("The balloon does not touch ground in the given time.")
}
