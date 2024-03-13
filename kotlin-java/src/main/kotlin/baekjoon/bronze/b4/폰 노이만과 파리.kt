package baekjoon.bronze.b4

fun main() {
    val (s, t, d) = readln().split(" ").map { it.toDouble() }
    println((d / (2 * s) * t).toInt())
}