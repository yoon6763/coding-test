package baekjoon.bronze.b4

fun main() = readln().toInt().let { println(if (it <= 100000 && it % 2024 == 0) "Yes" else "No") }