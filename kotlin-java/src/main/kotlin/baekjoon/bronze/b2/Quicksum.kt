package baekjoon.bronze.b2

fun main() = generateSequence { readln() }
    .takeWhile { it != "#" }
    .forEach { println(it.mapIndexed { idx, c -> (idx + 1) * if (c == ' ') 0 else (c - 'A' + 1) }.sum()) }