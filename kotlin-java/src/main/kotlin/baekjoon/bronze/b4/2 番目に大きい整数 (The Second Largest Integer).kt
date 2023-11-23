package baekjoon.bronze.b4

fun main() = println(readln().split(" ").sortedBy { it.toInt() }[1])