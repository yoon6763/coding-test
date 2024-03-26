package baekjoon.bronze.b4

import kotlin.math.pow

fun main() {
    val n = readln().toDouble() / readln().toDouble().pow(2)
    when {
        n < 18.5 -> println("Underweight")
        n < 24 -> println("Normal weight")
        else -> println("Overweight")
    }
}