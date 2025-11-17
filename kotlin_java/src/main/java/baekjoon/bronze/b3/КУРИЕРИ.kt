package baekjoon.bronze.b3

import kotlin.math.min

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() / 1000 }
    val ans = min(company1(n), company2(n)) + min(company1(m), company2(m))
    println("%.2f".format(ans / 100.0))
}

fun company1(x: Int): Int {
    return when {
        x <= 5 -> 400
        x <= 10 -> 700
        x <= 20 -> 1200
        x <= 30 -> 1700
        else -> x * 57
    }
}

fun company2(x: Int): Int {
    return when {
        x <= 2 -> 90 + x * 90
        x <= 5 -> 100 + x * 85
        x <= 20 -> 125 + x * 80
        x <= 40 -> 325 + x * 70
        else -> 925 + 55 * x
    }
}