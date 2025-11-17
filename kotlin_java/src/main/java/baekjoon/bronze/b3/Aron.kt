package baekjoon.bronze.b3

fun main() = print(List(readln().toInt()) { readln() }.zipWithNext().count { it.first != it.second } + 2)
