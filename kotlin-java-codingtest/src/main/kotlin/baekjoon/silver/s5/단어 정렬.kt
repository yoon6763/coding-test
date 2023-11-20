package baekjoon.silver.s5

fun main() = List(readln().toInt()) { readln() }.distinct().sortedWith(compareBy({ it.length }, { it })).forEach(::println)