package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println("${m * 2 - n} ${n - m * 2 / 2}")
}