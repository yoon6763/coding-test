package baekjoon.bronze.b1

import kotlin.math.pow
import kotlin.math.round

fun main() {
    var num = readln().toDouble()
    var pow = 0
    while (num >= 10) {
        num /= 10
        num = Math.round(num).toDouble()
        pow++
    }

    println((num * 10.0.pow(pow)).toLong())
}