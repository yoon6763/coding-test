package baekjoon.bronze.b3

fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }
    println(listOf(a * b + c * d, a * c + b * d, a * d + b * c).maxOrNull())
}