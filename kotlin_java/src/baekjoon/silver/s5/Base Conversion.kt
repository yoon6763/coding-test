package baekjoon.silver.s5

import kotlin.math.pow

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    readln()
    val arr = readln().split(" ").map { it.toInt() }.reversed()
    var x = arr.indices.sumOf { arr[it] * a.toDouble().pow(it).toInt() }

    val result = mutableListOf<Int>()
    while (x != 0) {
        result.add(x % b)
        x /= b
    }

    println(result.reversed().joinToString(" "))
}