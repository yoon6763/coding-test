package baekjoon.bronze.b4

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    println(3 + (2 * minOf(a - 2, b - 1)))
}