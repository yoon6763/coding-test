package baekjoon.bronze.b4

fun main() = repeat(readln().toInt()) {
    val (n, a, d) = readln().split(" ").map { it.toInt() }
    println((2 * a + (n - 1) * d) * n / 2)
}