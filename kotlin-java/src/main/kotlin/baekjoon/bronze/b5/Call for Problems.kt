package baekjoon.bronze.b5

fun main() = println(List(readln().toInt()) { readln().toInt() }.count { it % 2 == 1 })