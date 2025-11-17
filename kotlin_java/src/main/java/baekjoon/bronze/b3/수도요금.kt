package baekjoon.bronze.b3

fun main() {
    val (a, b, c, d, p) = List(5) { readln().toInt() }
    println(minOf(a * p, b + maxOf(0, p - c) * d))
}