package baekjoon.bronze.b4

fun main() = println(readln().split(" ").sumOf { "1".repeat(it.toInt()).toInt() })
