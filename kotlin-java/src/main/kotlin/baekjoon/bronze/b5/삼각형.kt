package baekjoon.bronze.b5

fun main() = readln().split(" ").map { it.toInt() }.let { (a, b) -> println("%.1f".format(a.toDouble() * b / 2)) }