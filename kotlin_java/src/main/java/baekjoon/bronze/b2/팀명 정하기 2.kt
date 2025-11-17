package baekjoon.bronze.b2

fun main() = print(List(readln().toInt()) { readln() }.first { it.count { it.isUpperCase() } <= it.count { it.isLowerCase() } && it.count { it.isDigit() } < it.length && it.length <= 10 })
