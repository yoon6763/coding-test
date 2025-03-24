package baekjoon.bronze.b4

fun main() = repeat(readln().toInt()) {
    val (c, p) = readln().split(" ").map { it.toInt() }
    println("$c $p\n${(c * p - (c - 1) * 2)}")
}