package baekjoon.bronze.b3

import kotlin.math.pow

fun main() {
    for (i in readln().toInt() + 1..9999) {
        val year = i.toString()
        if ((year.substring(0, 2).toDouble() + year.substring(2, 4).toDouble()).pow(2).toInt() == i) {
            println(i)
            return
        }
    }

    println("-1")
}