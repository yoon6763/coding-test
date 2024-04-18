package baekjoon.bronze.b2

fun main() = print(List(readln().toInt()) { readln().toSet() }.maxOf { it.size })