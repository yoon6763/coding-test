package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (n, k) = readln().split(" ").map { it.toInt() }
    println(readln().split(" ").map { it.toInt() }.sumOf { it/k })
}
