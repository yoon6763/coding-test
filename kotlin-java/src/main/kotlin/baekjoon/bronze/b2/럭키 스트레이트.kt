package baekjoon.bronze.b2

fun main() = readln().let { println(if (it.substring(0, it.length / 2).sumOf { it.digitToInt() } == it.substring((it.length + 1) / 2).sumOf { it.digitToInt() }) "LUCKY" else "READY") }