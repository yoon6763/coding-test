package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (a, b) = readln().split(" ").map { it.toLong() }
    println((a / b) * (a / b))
}
