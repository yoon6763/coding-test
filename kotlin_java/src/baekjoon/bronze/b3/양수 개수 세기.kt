package baekjoon.bronze.b3

fun main() = print(readln().split(" ").count { it.toInt() > 0 })