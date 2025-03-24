package baekjoon.bronze.b4

fun main() = print(List(readln().toInt()) { readln().split(" ").map { it.toInt() }.let { n -> (n[0] * (n[1] + n[2])).let { if (n[0] == (n[1] + n[2])) it * 2 else it } } }.max())