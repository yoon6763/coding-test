package baekjoon.bronze.b4

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println((n + m - 1) / m)
}