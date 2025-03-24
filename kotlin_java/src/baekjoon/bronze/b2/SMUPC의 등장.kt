package baekjoon.bronze.b2

fun main() = readln().forEach { println(it.toString().repeat(it.code.toString().sumOf { it.digitToInt() })) }
