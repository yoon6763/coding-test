package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (d, n, s, p) = readln().split(" ").map { it.toInt() }
    println(if ((n * s) < ((n * p) + d)) "do not parallelize" else if ((n * s) == ((n * p) + d)) "does not matter" else "parallelize")
}