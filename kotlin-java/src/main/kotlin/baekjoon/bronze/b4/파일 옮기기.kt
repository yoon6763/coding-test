package baekjoon.bronze.b4

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val (c, d) = readln().split(" ").map { it.toInt() }
    println(minOf(a + d, b + c))
}