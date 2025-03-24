package baekjoon.bronze.b3

fun main() = print(List(9) { readln() }.groupBy { it }.maxBy { it.value.size }.key)