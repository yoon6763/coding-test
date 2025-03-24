package baekjoon.bronze.b3

import kotlin.math.pow

fun main() = repeat(readln().trim().toInt()) {
    val (n, weight) = readln().trim().split(" ").map { it.toDouble() }
    var total = 0.0

    repeat(n.toInt()) {
        total += (4.0 / 3.0) * Math.PI * readln().trim().toDouble().pow(3) / 1000
    }

    println("Data Set ${it + 1}:")
    println(if (total >= weight) "Yes" else "No")
    println()
}