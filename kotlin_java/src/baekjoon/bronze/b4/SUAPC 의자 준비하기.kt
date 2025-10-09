package baekjoon.bronze.b4

fun main() {
    val (n, m, a, b) = readln().split(" ").map { it.toInt() }
    val min = n * 3 - m
    println(if (min <= 0) 0 else min * a + b)
}
